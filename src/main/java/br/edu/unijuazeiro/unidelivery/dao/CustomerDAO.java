package br.edu.unijuazeiro.unidelivery.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unijuazeiro.unidelivery.model.customer.Customer;

public class CustomerDAO {
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");

    public void save(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(customer);

        em.getTransaction().commit();
        em.close();
    }

    public void update(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(customer);

        em.getTransaction().commit();
        em.close();
    }

    public void remove(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, customer.getCode());
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }

    public Customer findById(Integer code) {
        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class, code);
        em.close();
        return c;
    }

    public List<Customer> list() {
        EntityManager em = emf.createEntityManager();
        List<Customer> customers = em.createQuery("from Customer", Customer.class).getResultList();
        em.close();
        return customers;
    }
}
