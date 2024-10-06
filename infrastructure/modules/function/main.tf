
locals {
  function_name = "${var.env}-${var.rev}-${var.name}-${random_pet.main.id}"
  repository_name = "${var.name}-${random_pet.main.id}"
}

resource "aws_ecr_repository" "main" {
  name                 = local.repository_name
  image_tag_mutability = "MUTABLE"

  image_scanning_configuration {
    scan_on_push = true
  }
}

resource "aws_lambda_function" "main" {
  function_name = local.function_name
  description   = var.description
  role          = aws_iam_role.main.arn
  filename      = var.file
  memory_size   = 256
  timeout       = 3
  handler       = "bootstrap"
  runtime       = "provided.al2023"
  logging_config {
    log_format            = "JSON"
    system_log_level      = "DEBUG"
    application_log_level = "DEBUG"
  }
  tracing_config {
    mode = "Active"
  }
  environment {
    variables = {
      ENV = var.env
      REV = var.rev
    }
  }
  tags = {
    Env = var.env
    Rev = var.rev
  }
}

resource "aws_iam_role" "main" {
  name               = "${local.function_name}-role"
  assume_role_policy = data.aws_iam_policy_document.assume_role.json
  tags = {
    Env = var.env
    Rev = var.rev
  }
}

resource "aws_iam_role_policy_attachment" "basic" {
  role       = aws_iam_role.main.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole"
}

resource "aws_iam_role_policy_attachment" "xray" {
  role       = aws_iam_role.main.name
  policy_arn = "arn:aws:iam::aws:policy/AWSXRayDaemonWriteAccess"
}

resource "aws_iam_role_policy_attachment" "vpc" {
  role       = aws_iam_role.main.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaVPCAccessExecutionRole"
}

data "aws_iam_policy_document" "assume_role" {
  statement {
    effect = "Allow"
    principals {
      type        = "Service"
      identifiers = ["lambda.amazonaws.com"]
    }
    actions = ["sts:AssumeRole"]
  }
}

resource "random_pet" "main" {
  length = 2
}