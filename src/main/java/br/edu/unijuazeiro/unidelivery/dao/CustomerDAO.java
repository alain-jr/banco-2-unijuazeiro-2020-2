package br.edu.unijuazeiro.unidelivery.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.edu.unijuazeiro.unidelivery.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.unidelivery.model.customer.Customer;

public class CustomerDAO {

    public void save(Customer customer) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void update(Customer customer) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void remove(Integer customerId) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, customerId);
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public Customer findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Customer c = em.find(Customer.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return c;
    }

    public Customer findByEmail(String email) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Customer c = null;
        try {
            c = em.createQuery("from Customer c where c.email = :mail", Customer.class).setParameter("mail", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            // System.out.println("Não foi encontrado cliente com esse e-mail.");
            return null;
        }
        if (em.isOpen()) {
            em.close();
        }
        return c;
    }

    public List<Customer> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Customer> customers = em.createQuery("select c from Customer c where lower(c.name) like lower(:name)", Customer.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return customers;
    }

    public List<Customer> findByAddress(String street) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Customer> customers = em.createQuery("select c from Customer c join c.address a where lower(a.street) like lower(:street)", Customer.class)
                .setParameter("street", "%" + street + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return customers;
    }

    public List<Customer> findByNameOrAddress(String text) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Customer> customers = em.createQuery("select c from Customer c join c.address a "+
           "where lower(c.name) like lower(:search) or lower(a.street) like lower(:search)", Customer.class)
                .setParameter("search", "%" + text + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return customers;
    }


    public List<Customer> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Customer> customers = em.createQuery("from Customer", Customer.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return customers;
    }
}
