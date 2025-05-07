
package me.fit.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import me.fit.rest.client.*;

import java.util.List;

@ApplicationScoped
public class HolidayService {

    @Inject
    @RestClient
    NagerApiClient nagerApiClient;

    public List<CountryDto> getCountries() {
        return nagerApiClient.getAvailableCountries();
    }

    public List<PublicHolidayDto> getNextPublicHolidays(String countryCode) {
        return nagerApiClient.getNextPublicHolidays(countryCode);
    }
}
