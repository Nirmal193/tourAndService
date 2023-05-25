package com.cityservices.tour.repository;


import com.cityservices.tour.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    // Additional query methods if needed
}
