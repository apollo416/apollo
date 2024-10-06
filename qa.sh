#!/bin/bash

mvn clean install package -DincludeScope=runtime

docker build -t create-decision-lambda \
	./apollo-decision -f ./apollo-decision/create-decision-lambda.Dockerfile

aws ecr get-login-password --region us-east-1 | docker \
	login --username AWS --password-stdin 590968261592.dkr.ecr.us-east-1.amazonaws.com/decision-crisp-bluebird

docker tag create-decision-lambda:latest 590968261592.dkr.ecr.us-east-1.amazonaws.com/decision-crisp-bluebird:main

docker push 590968261592.dkr.ecr.us-east-1.amazonaws.com/decision-crisp-bluebird:main

terraform -chdir=./infrastructure init \
    -backend-config=bucket=apollo416-apollo-qa \
    -backend-config=key=qa/app/terraform.tfstate \
    -backend-config=dynamodb_table=apollo416-apollo-qa

terraform -chdir=./infrastructure plan \
    -var='env=qa' \
    -var='rev=main' \
    -out=tfplan.out

terraform -chdir=./infrastructure apply -auto-approve tfplan.out
