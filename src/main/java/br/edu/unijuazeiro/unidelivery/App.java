package br.edu.unijuazeiro.unidelivery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // INSERT
        // Customer c = new Customer(2, "João Alencar");
        // em.persist(c);

        // SELECT
        // Customer c = em.find(Customer.class, 2);
        // System.out.println("Codigo " + c.getCode());
        // System.out.println("Nome " + c.getName());

        // UPDATE AND REMOVE
        Customer c = em.find(Customer.class, 1);
        System.out.println("Nome " + c.getName());

        //em.merge(c); // envia para banco
        //em.refresh(c); // traz pra aplicacao/atualiza o objeto na aplicacao
        em.remove(c);

        em.getTransaction().commit();

        em.close();

        emf.close();

        System.out.println("objeto na aplicação: "+c.getName());

    }
}