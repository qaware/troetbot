# Trötbot

This bot retrieves toots from [Mastodon](https://joinmastodon.org).


## What does "Tröt" mean anyway?

"Tröt" is the German word for toot, the noise a mastodon or elephant makes while exhaling through their [proboscis](https://en.wikipedia.org/wiki/Proboscis). 


## Setup for local development with QuarkusDev

1. Set your instance's hostname in `src/main/resources/application.properties`.
2. Retrieve an Access Token from your mastodon instance:.
   1. Go to settings / development.
   2. Create a new application.
   3. Required privileges: `read`.
3. Copy the file `env.template` to `.env`.
4. Paste your access token.
5. Start the application with `./gradlew quarkusDev`


## OpenAPI specification

OpenAPI specification can be received from http://localhost:8080/q/openapi.

Swagger UI is available at http://localhost:8080/q/swagger-ui.

## Running in a local kubernetes cluster
Bootstrap a cluster by following the [instructions](src/main/kubernetes/kind/Readme.md).

Set your mastodon instance and access token [here](src/main/kubernetes/environment/local).

If you are currently developing and want to test your changes locally use: 
```shell
$ tilt up -- --local 
```
This will run a `gradle build` and update the deployed image whenever changes are made.
The troetbot should be available under http://localhost:8888.

