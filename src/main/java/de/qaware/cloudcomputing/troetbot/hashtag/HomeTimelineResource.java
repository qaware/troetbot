package de.qaware.cloudcomputing.troetbot.hashtag;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import social.bigbone.MastodonClient;
import social.bigbone.MastodonRequest;
import social.bigbone.api.Pageable;
import social.bigbone.api.entity.Status;
import social.bigbone.api.exception.BigBoneRequestException;

import java.util.List;

@Path("/")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class HomeTimelineResource {

    @Inject
    MastodonClient mastodonClient;

    @GET
    @Path("/home")
    @WithSpan
    @Operation(summary = "Retrieves the latest toots from the home timeline.")
    @APIResponse(
            description = "Returns a list of status objects.",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(type = SchemaType.ARRAY, implementation = Status.class))
    )
    public List<Status> getHomeTimeline() {
        try {
            MastodonRequest<Pageable<Status>> request = mastodonClient.timelines().getHomeTimeline();
            Pageable<Status> response = request.execute();

            return response.getPart();
        } catch (BigBoneRequestException e) {
            throw new RuntimeException(e);
        }
    }

}
