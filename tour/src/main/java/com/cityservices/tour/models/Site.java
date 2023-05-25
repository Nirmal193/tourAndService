package com.cityservices.tour.models;

import javax.persistence.*;

@Entity
@Table(name = "site")
public class Site {

    private Long id;
    private String name;
    private String lattitude;
    private String longitude;


    private String description;

    private City city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    private Country country;

    public Site() {
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
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "lattitude", nullable = false)
    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
    @Column(name = "longitude", nullable = false)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Site(String name, String lattitude, String longitude, String description,Country country) {
        this.name = name;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.description = description;
        this.country = country;
    }
}
