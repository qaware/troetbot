package de.qaware.cloudcomputing.troetbot.hashtag;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import social.bigbone.MastodonClient;
import social.bigbone.MastodonRequest;
import social.bigbone.api.Pageable;
import social.bigbone.api.Range;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

@Path("/")
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
public class HashtagResource {

    @Inject
    MastodonClient mastodonClient;

    @GET
    @Produces("text/html")
    @Path("/hashtags")
    public String getPopularHashtags() {

        try {
            MastodonRequest<Pageable<Status>> request = mastodonClient.timelines().getHomeTimeline();
            Pageable<Status> response = request.execute();

            StringBuilder stringBuilder = new StringBuilder();
            for (Status status : response.getPart()) {
                stringBuilder.append("<div style=\"border: 1px solid; margin-bottom: 1em;\">");
                stringBuilder.append(status.getAccount().getDisplayName());
                stringBuilder.append("<hr />");
                stringBuilder.append(status.getContent());
                stringBuilder.append("</div>");
            }
            return stringBuilder.toString();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
    }

}
