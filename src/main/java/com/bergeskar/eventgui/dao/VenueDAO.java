package com.bergeskar.eventgui.dao;


import com.bergeskar.eventgui.entity.Venue;

import java.util.List;

public class VenueDAO extends GenericDAO<Venue> {

    public VenueDAO() {
        super();
    }


    public void create(Venue venue) {
        executeInsideTransaction(entityManager -> entityManager.persist(venue));

    }

    public List<Venue> read() {
        return entityManager.createNativeQuery("SELECT * FROM Venue", Venue.class).getResultList();

    }

    public void update(Venue venue) {
        executeInsideTransaction(entityManager -> entityManager.merge(venue));
    }

    public void delete(Venue venue) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(venue)));

    }


}

