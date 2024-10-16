variable "name" {
  description = "The name of the function"
  type        = string
}

variable "description" {
  description = "The description of the function"
  type        = string
}

variable "dockerfile" {
  description = "The path to the Dockerfile"
  type        = string
}

variable "env" {
  description = "The environment for the function"
  type        = string
  validation {
    condition     = contains(["dev", "qa", "prd"], var.env)
    error_message = "Valid values for env are (dev, qa, prd)"
  }
}

variable "rev" {
  description = "The revision for the function"
  type        = string
}