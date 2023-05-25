package com.cityservices.tour.services;



import com.cityservices.tour.models.Site;

import java.util.List;

public interface SiteService {
    List<Site> getAllSites();
    Site getSiteById(Long id);
    Site addSite(Site site);
    Site updateSite(Site site);
    void deleteSite(Long id);
    List<Site> getSitesByCountry(String countryName);
    List<Site> getSitesByCity(String cityName);
}
