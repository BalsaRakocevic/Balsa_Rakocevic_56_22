package me.fit.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.fit.entity.WeatherData;

@ApplicationScoped
public class WeatherRepository {

    @PersistenceContext
    EntityManager em;

    public WeatherData findByCity(String city) {
        return em.find(WeatherData.class, city);
    }

    public void save(WeatherData weatherData) {
        em.persist(weatherData);
    }

    public void update(WeatherData weatherData) {
        em.merge(weatherData);
    }
}