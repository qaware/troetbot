package de.qaware.cloudcomputing.troetbot.mastodon;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import social.bigbone.MastodonClient;
import social.bigbone.MastodonRequest;
import social.bigbone.api.entity.Token;
import social.bigbone.api.exception.BigBoneRequestException;

@ApplicationScoped
public class MastodonClientProducer {

    @ConfigProperty(name = "mastodon.instance.hostname")
    String instanceHostname;

    @ConfigProperty(name = "mastodon.oauth.clientId")
    String clientId;

    @ConfigProperty(name = "mastodon.oauth.clientSecret")
    String clientSecret;

    @Produces
    @RestClient
    @ApplicationScoped
    public MastodonClient produce() {
        Token accessToken = getAccessToken();
        return new MastodonClient.Builder(instanceHostname)
                .accessToken(accessToken.getAccessToken())
                .build();
    }

    private Token getAccessToken() {
        MastodonClient mastodonClient = new MastodonClient.Builder(instanceHostname).build();

        try {
            MastodonRequest<Token> authRequest = mastodonClient.oauth().getAccessTokenWithClientCredentialsGrant(clientId, clientSecret, "");
            return authRequest.execute();
        } catch (BigBoneRequestException e) {
            throw new WebApplicationException(e);
        }
    }

}
