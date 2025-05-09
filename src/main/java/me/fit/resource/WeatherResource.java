package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.fit.service.WeatherService;
import me.fit.entity.WeatherData;
import me.fit.repository.WeatherRepository;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/my-weather")
public class WeatherResource {

    @Inject
    @RestClient
    WeatherService weatherService;

    @GET
    @Path("/getForecast")
    @Produces(MediaType.APPLICATION_JSON)
    public String getForecast(@QueryParam("city") String city) {

        WeatherData weatherData = weatherRepository.findByCity(city);

        String weatherInfo = weatherService.getWeather(city);


        WeatherData weatherData = new WeatherData();
        weatherData.setCity(city);
        weatherData.setweatherInfo(weatherInfo);
        return weatherService.getWeather(city);
    }
}