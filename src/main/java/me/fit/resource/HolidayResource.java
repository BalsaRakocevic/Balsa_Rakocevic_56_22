
package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.service.HolidayService;
import me.fit.rest.client.CountryDto;
import me.fit.rest.client.PublicHolidayDto;

import java.util.List;

@Path("/holidays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayResource {

    @Inject
    HolidayService holidayService;

 
    @GET
    @Path("/available-countries")
    public List<CountryDto> getAvailableCountries() {
        return holidayService.getCountries();
    }

    @GET
    @Path("/next/{countryCode}")
    public Response getNextHolidays(@PathParam("countryCode") String countryCode) {
        try {
            List<PublicHolidayDto> holidays = holidayService.getNextPublicHolidays(countryCode);
            return Response.ok(holidays).build();
        } catch (WebApplicationException e) {
            // Log the error and return a 404 or appropriate error message
            return Response.status(e.getResponse().getStatus())
                    .entity("Error fetching holidays for country code: " + countryCode)
                    .build();
        } catch (Exception e) {
            // Generic error handling
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while fetching holidays")
                    .build();
        }
    }
 
}
