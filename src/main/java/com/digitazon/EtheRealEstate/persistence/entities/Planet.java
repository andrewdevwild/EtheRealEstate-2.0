package com.digitazon.EtheRealEstate.persistence.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "distance")
    private String distance;
    @Column(name = "population")
    private String population;
    @Column(name = "discovery_date")
    private String discoveryDate;

    @Column(name = "gravity")
    private String gravity;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte [] image;

    @OneToMany(mappedBy = "planet")
    private List<Exohouse> exohouses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public List<Exohouse> getExohouses() {
        return exohouses;
    }

    public void setExohouses(List<Exohouse> exohouses) {
        this.exohouses = exohouses;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
