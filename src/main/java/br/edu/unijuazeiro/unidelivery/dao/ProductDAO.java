package br.edu.unijuazeiro.unidelivery.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unijuazeiro.unidelivery.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.unidelivery.model.product.Product;

public class ProductDAO {

    public void save(Product product) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(product);
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

    public void update(Product product) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(product);
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

    public void remove(Product product) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Product p = em.find(Product.class, product.getCode());
            em.remove(p);
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

    public Product findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Product p = em.find(Product.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return p;
    }

    public List<Product> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Product> products = em.createQuery("from Product", Product.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return products;
    }

}
