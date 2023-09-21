# Trötbot

This bot retrieves toots from [Mastodon](https://joinmastodon.org).


## What does "Tröt" mean anyway?

"Tröt" is the German word for toot, the noise a mastodon or elephant makes while exhaling through their [proboscis](https://en.wikipedia.org/wiki/Proboscis). 


## Setup

1. Set your instance's hostname in `src/main/resources/application.properties`.
2. Retrieve an Access Token from your mastodon instance:.
   1. Go to settings / development.
   2. Create a new application.
   3. Required privileges: `read`.
3. Copy the file `env.template` to `.env`.
4. Paste your access token.


## OpenAPI specification

OpenAPI specification can be received from http://localhost:8080/q/openapi.

Swagger UI is available at http://localhost:8080/q/swagger-ui.
