package com.cityservices.tour.controller;


import com.cityservices.tour.models.City;
import com.cityservices.tour.models.Site;
import com.cityservices.tour.repository.CityRepository;
import com.cityservices.tour.services.CityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    CityRepository cityRepository;

    @GetMapping
    public Page<City> getAllCities(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return cityService.getAllCities(pageable);
    }

    @GetMapping("/unique-city-names")
    public List<String> getUniqueCityNames() {
        return cityRepository.findDistinctName();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PutMapping("/update/{cityName}")
    public City updateCity(@RequestParam String oldCityName,@RequestBody City city) throws NotFoundException {
         cityService.updateCity(oldCityName,city.getName(),city.getLogoUrl());
         return cityRepository.findByName(city.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

    @GetMapping("/{cityName}/sites")
    public List<Site> getSitesByCityName(@PathVariable String cityName) {
        return cityService.getSitesByCityName(cityName);
    }
}
