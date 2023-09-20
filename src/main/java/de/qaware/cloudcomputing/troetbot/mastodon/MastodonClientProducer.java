package de.qaware.cloudcomputing.troetbot.mastodon;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import social.bigbone.MastodonClient;

@ApplicationScoped
public class MastodonClientProducer {

    @ConfigProperty(name = "mastodon.instance.hostname")
    String instanceHostname;

    @ConfigProperty(name = "mastodon.access.token")
    String accessToken;

    @Produces
    @ApplicationScoped
    public MastodonClient produce() {
        return new MastodonClient
                .Builder(instanceHostname)
                .accessToken(accessToken)
                .build();
    }
}
