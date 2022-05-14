package com.bergeskar.eventgui.entity;

import javax.persistence.*;

@Entity(name="Consert")
@Table(name="consert")
public class Consert {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "consert_id")
    private int consert_id;
    @Basic
    @Column(name = "artist")
    private String artist;
    @Basic
    @Column(name = "consert_date")
    private String consert_date;
    @Basic
    @Column(name = "ticket_price")
    private String ticket_price;
    @Basic
    @Column(name = "venue")
    private String venue;


    public Consert() {
    }
    public Consert(int consert_id, String artist, String consert_date, String ticket_price, String venue) {
        this.consert_id = consert_id;
        this.artist = artist;
        this.consert_date = consert_date;
        this.ticket_price = ticket_price;
        this.venue = venue;
    }



    public int getConsert_id() {
        return consert_id;
    }

    public void setConsert_id(int consert_id) {
        this.consert_id = consert_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getConsert_date() {
        return consert_date;
    }

    public void setConsert_date(String consert_date) {
        this.consert_date = consert_date;
    }

    public String getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(String ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String toString() {
        return  consert_id + artist +" " +consert_date + " " + ticket_price + " " +venue;
    }
}


