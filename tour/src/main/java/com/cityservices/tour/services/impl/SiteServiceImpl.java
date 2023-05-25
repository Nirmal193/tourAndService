package com.cityservices.tour.services.impl;


import com.cityservices.tour.models.Site;
import com.cityservices.tour.services.SiteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Override
    public List<Site> getAllSites() {
        return null;
    }

    @Override
    public Site getSiteById(Long id) {
        return null;
    }

    @Override
    public Site addSite(Site site) {
        return null;
    }

    @Override
    public Site updateSite(Site site) {
        return null;
    }

    @Override
    public void deleteSite(Long id) {

    }

    @Override
    public List<Site> getSitesByCountry(String countryName) {
        return null;
    }

    @Override
    public List<Site> getSitesByCity(String cityName) {
        return null;
    }
}
