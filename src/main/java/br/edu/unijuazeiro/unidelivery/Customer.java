package br.edu.unijuazeiro.unidelivery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private Integer code;

    private String name;

}
