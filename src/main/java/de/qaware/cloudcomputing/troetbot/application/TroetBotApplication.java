package de.qaware.cloudcomputing.troetbot.application;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "TroetBot API",
                description = "Mastodon bot to scrape toots",
                version = "1.0.0",
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/license/mit/"))
)
public class TroetBotApplication extends Application {
}
