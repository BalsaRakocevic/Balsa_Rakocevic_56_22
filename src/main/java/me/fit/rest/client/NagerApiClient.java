
package me.fit.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@RegisterRestClient(configKey = "nager-date-api")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NagerApiClient {

    @GET
    @Path("/AvailableCountries")
    List<CountryDto> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<PublicHolidayDto> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}
