package br.edu.unijuazeiro.unidelivery;

import br.edu.unijuazeiro.unidelivery.dao.CustomerDAO;
import br.edu.unijuazeiro.unidelivery.model.customer.Customer;

public final class App {

    private App() {
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();

        Customer c = new Customer();
        c.setName("Carlitos");
        c.setEmail("carlitos@gmail.com");
        
        dao.save(c);

        dao.emf.close();

    }
}