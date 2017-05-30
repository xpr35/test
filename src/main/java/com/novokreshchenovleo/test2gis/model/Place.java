package com.novokreshchenovleo.test2gis.model;

/**
 * Created by xpres on 26/05/17.
 */
public class Place implements Comparable<Place> {
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public Float getRating() {
        return rating;
    }

    private String name;
    private String address;
    private Float rating;

    public int compareTo(Place place) {
        if (this.rating < place.rating)
            return 1;
        else if (this.rating > place.rating)
            return -1;
        else
            return 0;
    }

    public Place(String name, String city, String address, Float rating) {
        this.name = name;
        this.address = city + ", " + address;
        this.rating = rating;
    }

}