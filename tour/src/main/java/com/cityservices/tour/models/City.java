package com.cityservices.tour.models;


import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    private Long id;
    private String name;

    private String logoUrl;
    private String State;

    private Country country;

    private List<Site> siteList;
    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public City() {
    }

    public City(String name, String logoUrl, String state) {
        this.name = name;
        this.logoUrl = logoUrl;
        State = state;
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
        boolean hasEditorRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_EDITOR"));

        if (hasEditorRole) {
            this.name = name;
        } else {
            throw new IllegalStateException("Only users with the 'EDITOR' role can edit the city name.");
        }
    }


    @Column(name = "logoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        boolean hasEditorRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_EDITOR"));

        if (hasEditorRole) {
            this.logoUrl = logoUrl;
        } else {
            throw new IllegalStateException("Only users with the 'EDITOR' role can edit the city logo.");
        }
    }

    @Column(name = "state")
    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

}
