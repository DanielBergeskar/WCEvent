package com.bergeskar.eventgui.dao;



import com.bergeskar.eventgui.entity.Customer;

import java.util.List;

public class CustomerDAO extends GenericDAO<Customer> {

    public CustomerDAO() {
        super();
    }


    public void create(Customer customer) {
        executeInsideTransaction(entityManager -> entityManager.persist(customer));

    }

    public List<Customer> read() {
        return entityManager.createNativeQuery("SELECT * FROM Customer", Customer.class).getResultList();

    }

    public void update(Customer customer) {

        executeInsideTransaction(entityManager -> entityManager.merge(customer));
    }

    public void delete(Customer customer) {
        executeInsideTransaction(entityManager -> entityManager.remove(entityManager.merge(customer)));

    }


}

