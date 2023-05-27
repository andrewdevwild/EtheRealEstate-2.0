package com.digitazon.EtheRealEstate.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exohouse")
public class Exohouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planet;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "price")
    private String price;
    @Column(name = "is_available")
    private boolean isAvailable;
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte [] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
