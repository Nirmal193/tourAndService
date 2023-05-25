package com.cityservices.tour.services.impl;


import com.cityservices.tour.models.Country;
import com.cityservices.tour.models.Site;
import com.cityservices.tour.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public List<Country> getAllCountries() {
        return null;
    }

    @Override
    public Country getCountryById(Long id) {
        return null;
    }

    @Override
    public Country addCountry(Country country) {
        return null;
    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public void deleteCountry(Long id) {

    }

    @Override
    public List<Site> getSitesByCountryName(String countryName) {
        return null;
    }
}
