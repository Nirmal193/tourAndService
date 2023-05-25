package com.cityservices.tour.controller;

import com.cityservices.tour.models.Site;
import com.cityservices.tour.repository.SiteRepository;
import com.cityservices.tour.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sites")
public class SiteController {
    @Autowired
    SiteService siteService;

    @Autowired
    SiteRepository siteRepository;


    @GetMapping
    public List<Site> getAllSites() {
        return siteService.getAllSites();
    }

    @GetMapping("/sites/{countryName}")
    public List<Site> getSitesByCountryName(@PathVariable String countryName) {
        return siteRepository.findAllByCountryName(countryName);
    }

    @GetMapping("/sites/{cityName}")
    public List<Site> getSitesByCityName(@PathVariable String cityName) {
        return siteRepository.findAllByCityNameCustomQuery(cityName);
    }

    @GetMapping("/{id}")
    public Site getSiteById(@PathVariable Long id) {
        return siteService.getSiteById(id);
    }

    @PostMapping
    public Site addSite(@RequestBody Site site) {
        return siteService.addSite(site);
    }

    @PutMapping("/{id}")
    public Site updateSite(@PathVariable Long id, @RequestBody Site site) {
        site.setId(id);
        return siteService.updateSite(site);
    }

    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable Long id) {
        siteService.deleteSite(id);
    }
}
