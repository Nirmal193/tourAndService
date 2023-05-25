package com.cityservices.tour.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Coutry")
public class Country {

    private Long id;
    private String name;
    private Integer population;
    private Integer area;
    private String currency;
    private String language;

    private String capital;


    private List<City> cityList;

    public Country(String name, Integer population,String capital ,Integer area, String currency, String language) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.area = area;
        this.currency = currency;
        this.language = language;
    }


    public Country() {
    }
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    @Column(name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Column(name="currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name="language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name= "capital")
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    public List<City> getCityList() {
        return cityList;
    }


    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
