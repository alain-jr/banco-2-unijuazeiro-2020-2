package br.edu.unijuazeiro.unidelivery.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.unidelivery.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.unidelivery.model.order.Order;

public class OrderDAO {

    public void save(Order order) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
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

    public void update(Order order) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(order);
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

    public void remove(Order order) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Order o = em.find(Order.class, order.getCode());
            em.remove(o);
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

    public Order findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Order o = em.find(Order.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return o;
    }

    public List<Order> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Order> orders = em.createQuery("from Order", Order.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return orders;
    }
}
