package com.cityservices.tour.repository;

import com.cityservices.tour.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT DISTINCT name FROM City c")
    List<String> findDistinctName();

    @Query("SELECT c FROM City c WHERE c.name = :name")
    City findByName(@Param("name") String name);
}
