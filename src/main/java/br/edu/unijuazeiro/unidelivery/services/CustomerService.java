package br.edu.unijuazeiro.unidelivery.services;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.edu.unijuazeiro.unidelivery.dao.CustomerDAO;
import br.edu.unijuazeiro.unidelivery.model.customer.Customer;

public class CustomerService {

    private CustomerDAO customerDAO = new CustomerDAO();

    public void save(Customer customer) {
        if (customer.getName().length() > 30) {
            // disparo uma exception
        }
        customerDAO.save(customer);
    }

    public void update(Customer customer) {
        if (customer.getPassword() == null) {
            throw new RuntimeException("Senha obrigatória");
        }
        String pwdCipher = BCrypt.withDefaults().hashToString(11, customer.getPassword().toCharArray());
        System.out.println(pwdCipher);
        customer.setPassword(pwdCipher);
        customerDAO.update(customer);
    }

    public Customer login(String email, String password) {
        Customer c = customerDAO.findByEmail(email);
        if (c == null) {
            throw new RuntimeException("Dados inválido");
        }
        if (!BCrypt.verifyer().verify(password.toCharArray(), c.getPassword().toCharArray()).verified) {
            throw new RuntimeException("Dados inválido 2");
        }
        return c;
    }

    public List<Customer> list() {
        return customerDAO.list();
    }

}
