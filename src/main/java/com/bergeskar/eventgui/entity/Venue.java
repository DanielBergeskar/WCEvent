package com.bergeskar.eventgui.entity;

import javax.persistence.*;


@Entity
@Table(name="venue")
public class Venue {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "venue_id")
    private int venue_id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "indoor/outdoor")
    private String indoor_outdoor;

    public Venue() {
    }

    public Venue(int venue_id, String name, String address, String indoor_outdoor) {
        this.venue_id = venue_id;
        this.name = name;
        this.address = address;
        this.indoor_outdoor = indoor_outdoor;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndoor_outdoor() {
        return indoor_outdoor;
    }

    public void setIndoor_outdoor(String indoor_outdoor) {
        this.indoor_outdoor = indoor_outdoor;
    }

    @Override
    public String toString() {
        return venue_id +" " + name +" " + address +" "+ indoor_outdoor;

    }
}