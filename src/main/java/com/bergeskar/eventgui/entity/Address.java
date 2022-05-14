package com.bergeskar.eventgui.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Address")
@Table(name="address")
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "address_id")
    private int address_id;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "b_number")
    private String b_number;
    @Basic
    @Column(name = "zip_code")
    private String zip_code;
    @Basic
    @Column(name = "city")
    private String city;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private List<Venue> venues;

    public Address() {
    }

    public Address(int address_id, String street, String b_number, String zip_code, String city) {
        this.address_id = address_id;
        this.street = street;
        this.b_number = b_number;
        this.zip_code = zip_code;
        this.city = city;

    }

    public Address(String text, String text1, String text2, String text3) {
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getB_number() {
        return b_number;
    }

    public void setB_number(String b_number) {
        this.b_number = b_number;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public String toString() {
        return  address_id + " " + street +" "+  b_number +" " + zip_code + " " +
                city + " ";}


    }
