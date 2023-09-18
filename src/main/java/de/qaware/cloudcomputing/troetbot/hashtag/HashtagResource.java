package de.qaware.cloudcomputing.troetbot.hashtag;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import social.bigbone.MastodonClient;
import social.bigbone.MastodonRequest;
import social.bigbone.api.Pageable;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

@Path("/")
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
public class HashtagResource {

    @RestClient
    MastodonClient mastodonClient;

    @GET
    @Path("/hashtags")
    public String getPopularHashtags() {
        try {
            MastodonRequest<Pageable<Status>> request = mastodonClient.timelines().getHomeTimeline();
            Pageable<Status> response = request.execute();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

}
