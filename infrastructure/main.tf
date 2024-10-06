

module "engine" {
  source      = "./modules/function"
  name        = "decision"
  description = "Decision Engine Core"
  env         = var.env
  rev         = var.rev
  file        = "${path.module}/bin/engine/bootstrap"
}