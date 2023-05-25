package com.cityservices.tour.repository;

import com.cityservices.tour.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    // Additional query methods if needed
    @Query("SELECT s FROM Site s WHERE s.country.name = :countryName")
    List<Site> findAllByCountryName(@Param("countryName") String countryName);

    @Query("SELECT s FROM Site s WHERE s.city.name = ?1")
    List<Site> findAllByCityNameCustomQuery(@Param("cityName") String cityName);
}
