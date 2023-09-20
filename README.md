# troetbot

This bot retrieves Toots from [Mastodon](https://joinmastodon.org).

## Setup

1. Set your instance's hostname in `src/main/resources/application.properties`.
2. Retrieve an Access Token from your mastodon instance:.
   1. Go to settings / development.
   2. Create a new application.
   3. Required privileges: `read`.
3. Copy the file `env.template` to `.env`.
4. Paste your access token.
