

module "engine" {
  source      = "./modules/function"
  name        = "decision"
  description = "Decision Engine Core"
  dockerfile  = "./apollo-decision/create-decision-lambda.Dockerfile"
  env         = var.env
  rev         = var.rev
}