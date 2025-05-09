package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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

    @Inject
    WeatherRepository weatherRepository;

    @GET
    @Path("/getForecast")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public String getForecast(@QueryParam("city") String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }

        WeatherData existingWeatherData = weatherRepository.findByCity(city);
        if (existingWeatherData == null) {
            existingWeatherData = new WeatherData();
            existingWeatherData.setCity(city);
        }

        String weatherInfo = weatherService.getWeather(city);
        existingWeatherData.setWeatherInfo(weatherInfo);
        weatherRepository.save(existingWeatherData);
        return weatherInfo;
    }
}