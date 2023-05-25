package com.cityservices.tour.services.impl;


import com.cityservices.tour.models.City;
import com.cityservices.tour.models.Site;
import com.cityservices.tour.repository.CityRepository;
import com.cityservices.tour.services.CityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Override
    public Page<City> getAllCities(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }


    @Override
    public City getCityById(Long id) {
        return null;
    }

    @Override
    public City addCity(City city) {
        return null;
    }

    @Override
    public void updateCity(String cityName, String newCityName, String newCityLogo) throws NotFoundException {
        City city = cityRepository.findByName(cityName);
        if (city != null) {
            city.setName(newCityName);
            city.setLogoUrl(newCityLogo);
            cityRepository.save(city);
        } else {
            throw new NotFoundException("City not found.");
        }
    }

    @Override
    public void deleteCity(Long id) {

    }

    @Override
    public List<Site> getSitesByCityName(String cityName) {
        return null;
    }
}
