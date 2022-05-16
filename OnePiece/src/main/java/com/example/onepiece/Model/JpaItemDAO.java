package com.example.onepiece.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.*;
import java.util.List;

public class JpaItemDAO implements ItemDAO{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveItem(Item i) {
        entityManager.getTransaction().begin();
        entityManager.persist(i);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteItem(Item i) {
        entityManager.getTransaction().begin();
        entityManager.remove(i);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateItem(Item i) {
        entityManager.getTransaction().begin();
        entityManager.persist(i);
        entityManager.getTransaction().commit();
        saveItem(i);
    }

    @Override
    public List<Item> listItems() {
        TypedQuery<Item> query = entityManager.createQuery(
                "SELECT i FROM Item i", Item.class);
        List<Item> items = query.getResultList();
        return items;
    }

    @Override
    public void saveCategory(Category dairy) {
        entityManager.getTransaction().begin();
        entityManager.persist(dairy);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
