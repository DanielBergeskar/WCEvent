package com.bergeskar.eventgui.dao;


import com.bergeskar.eventgui.entity.Consert;

import java.util.List;


public class ConsertDAO extends GenericDAO<Consert> {

    public ConsertDAO() {
        super();
    }


    public void create(Consert consert) {
        executeInsideTransaction(entityManager -> entityManager.persist(consert));

    }

    public List<Consert> read() {
        return entityManager.createNativeQuery("SELECT * FROM Consert", Consert.class).getResultList();

    }

    public void update(Consert consert) {
        executeInsideTransaction(entityManager -> entityManager.merge(consert));
    }

    public void delete(Consert consert) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(consert)));

    }


}

