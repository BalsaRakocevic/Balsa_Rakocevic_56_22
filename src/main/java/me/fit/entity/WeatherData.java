package me.fit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class WeatherData {

    @Id
    private String city;
    private String weatherInfo;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}