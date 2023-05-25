package com.cityservices.tour.services;



import com.cityservices.tour.models.City;
import com.cityservices.tour.models.Site;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    Page<City> getAllCities(Pageable pageable);
    City getCityById(Long id);
    City addCity(City city);
    public void updateCity(String cityName, String newCityName, String newCityLogo) throws NotFoundException;
    void deleteCity(Long id);
    List<Site> getSitesByCityName(String cityName);
}
