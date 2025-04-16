package com.weathertrafficaggregator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.json.JSONArray;

/**
 * The type Location.
 */
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "radius")
    private double radius;

    @Column(name ="weatherAndTrafficDetails")
    private String weatherAndTrafficDetails;

    /**
     * Instantiates a new Location.
     */
    public Location() {
    }

    public Location(String zipcode, double radius, String weatherAndTrafficDetails) {
        this.zipcode = zipcode;
        this.radius = radius;
        this.weatherAndTrafficDetails = weatherAndTrafficDetails;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets zipcode.
     *
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets zipcode.
     *
     * @param zipcode the zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets radius.
     *
     * @param radius the radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Gets weather and traffic details.
     *
     * @return the weather and traffic details
     */
    public String getWeatherAndTrafficDetails() {
        return weatherAndTrafficDetails;
    }

    /**
     * Sets weather and traffic details.
     *
     * @param weatherAndTrafficDetails the weather and traffic details
     */
    public void setWeatherAndTrafficDetails(String weatherAndTrafficDetails) {
        this.weatherAndTrafficDetails = weatherAndTrafficDetails;
    }
}
