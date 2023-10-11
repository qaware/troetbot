#!/usr/bin/env bash

# This script builds the troetbot service container image for multiple architectures and pushes the
# respective images to the configured repository.

set -eo pipefail

export QUARKUS_CONTAINER_IMAGE_BUILD=true
export QUARKUS_JIB_PLATFORMS=linux/amd64,linux/arm64/v8
export QUARKUS_CONTAINER_IMAGE_PUSH=true
# set this to your image repository name
export QUARKUS_CONTAINER_IMAGE_GROUP=qalukasbuchner

./gradlew build