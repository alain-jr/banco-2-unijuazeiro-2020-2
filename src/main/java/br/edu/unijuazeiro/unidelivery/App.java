package br.edu.unijuazeiro.unidelivery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.unijuazeiro.unidelivery.model.customer.Customer;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-unijuazeiro");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();// inicio da transação

        // INSERT
        // Customer c = new Customer();
        // c.setName("maria");
        // c.setEmail("maria@hotmail.com");
        // c.setCreatedAt(new Date());

        // Address address = new Address();
        // address.setStreet("R. Sao Vicente");
        // address.setNumber("45A");

        // c.setAddress(address);

        // em.persist(c);

        // Product product = new Product();
        // product.setName("Hamburgue Verde");
        // product.setPrice(10.0);

        // em.persist(product);

        // SELECT
        Customer c = em.find(Customer.class, 8);
        System.out.println("Codigo " + c.getCode());
        System.out.println("Nome " + c.getName());
        System.out.println("E-mail " + c.getEmail());
        System.out.println("Rua " + c.getAddress().getStreet());
        System.out.println("Número " + c.getAddress().getNumber());

        // Address address = new Address();
        // address.setStreet("R. Sao Benedito");
        // address.setNumber("900");

        // c.setAddress(address);

        // em.merge(c);

        // Product product = em.find(Product.class, 1);
        // System.out.println(product.getName());

        // product.setName("Hambúrguer Quatro Queijos");

        // UPDATE AND REMOVE
        // Customer c = em.find(Customer.class, 1);
        // System.out.println("Nome " + c.getName());

        // em.merge(c); // envia para banco
        // em.refresh(c); // traz pra aplicacao/atualiza o objeto na aplicacao
        // em.remove(c);

        em.getTransaction().commit();

        em.close();

        emf.close();

    }
}