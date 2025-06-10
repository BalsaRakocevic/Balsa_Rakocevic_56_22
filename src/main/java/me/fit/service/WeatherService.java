package me.fit.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@RegisterRestClient(baseUri = "https://goweather.xyz/api/v2")
public interface WeatherService {

    @GET
    @Path("/weather/{city}")
    String getWeather(@PathParam("city") String city);
}