package br.edu.unijuazeiro.unidelivery;

import br.edu.unijuazeiro.unidelivery.dao.CustomerDAO;
import br.edu.unijuazeiro.unidelivery.dao.ProductDAO;
import br.edu.unijuazeiro.unidelivery.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.unidelivery.model.customer.Customer;
import br.edu.unijuazeiro.unidelivery.model.product.Product;

public final class App {

    private App() {
    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer c = new Customer();
        c.setName("Pedro");
        c.setEmail("pedro@gmail.com");

        customerDAO.save(c);

        System.out.println(ConnectionFactory.getEmf() + " cliente salvo!");

        ProductDAO productDAO = new ProductDAO();
        Product p = new Product();
        p.setName("Pão Doce");
        p.setPrice(5.0);

        productDAO.save(p);

        System.out.println(ConnectionFactory.getEmf() + " produto salvo!");

        ConnectionFactory.close();

    }
}