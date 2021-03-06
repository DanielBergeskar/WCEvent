package com.bergeskar.eventgui.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public abstract class GenericDAO<E> {

    public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    protected EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    protected EntityTransaction transaction = null;

    public void executeInsideTransaction(Consumer<EntityManager> action) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            action.accept(entityManager);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally{
            entityManager.close();
        }
    }

}
