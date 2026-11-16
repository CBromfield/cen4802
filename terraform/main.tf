terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0"
    }
  }
}

provider "docker" {}

resource "docker_network" "study_spot_network" {
  name = "study-spot-terraform-network"
}

resource "docker_container" "study_spot" {
  name  = "study-spot-terraform"
  image = "study-spot-finder:midterm"

  ports {
    internal = 8080
    external = 8086
  }

  networks_advanced {
    name = docker_network.study_spot_network.name
  }
}