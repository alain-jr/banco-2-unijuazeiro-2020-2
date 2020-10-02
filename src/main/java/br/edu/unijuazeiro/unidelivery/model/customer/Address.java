package br.edu.unijuazeiro.unidelivery.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_address")
    @SequenceGenerator(sequenceName = "seq_address", allocationSize = 1, initialValue = 1, name = "gen_address")
    private Integer code;

    private String street;

    private String number;

}
