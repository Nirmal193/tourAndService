package com.cityservices.tour.services;



import com.cityservices.tour.models.Country;
import com.cityservices.tour.models.Site;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country addCountry(Country country);
    Country updateCountry(Country country);
    void deleteCountry(Long id);
    List<Site> getSitesByCountryName(String countryName);
}
