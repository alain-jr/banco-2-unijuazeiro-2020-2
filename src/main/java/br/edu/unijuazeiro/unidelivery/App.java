package br.edu.unijuazeiro.unidelivery;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unijuazeiro.unidelivery.model.order.Item;
import br.edu.unijuazeiro.unidelivery.model.order.Order;
import br.edu.unijuazeiro.unidelivery.model.product.Product;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();// inicio da transação

        Order order = new Order();

        Product p1 = em.find(Product.class, 10);
        Item item = new Item();
        item.setProduct(p1);
        item.setQuantity(1.0);

        Product p2 = em.find(Product.class, 11);
        Item item2 = new Item();
        item.setProduct(p2);
        item.setQuantity(3.0);

        order.setItems(Arrays.asList(item, item2));
        ///order.sumTotal();

        // em.persist(order);

        em.createQuery("from tb_order", Order.class).getResultList().forEach(o -> {
            System.out.println("pedido: " + o.getCode()); 
            System.out.println("total: " + o.getTotal());
        });

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}