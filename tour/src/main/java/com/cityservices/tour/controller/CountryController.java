package com.cityservices.tour.controller;


import com.cityservices.tour.models.Country;
import com.cityservices.tour.models.Site;
import com.cityservices.tour.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }

    @GetMapping("/{countryName}/sites")
    public List<Site> getSitesByCountryName(@PathVariable String countryName) {
        return countryService.getSitesByCountryName(countryName);
    }
}
