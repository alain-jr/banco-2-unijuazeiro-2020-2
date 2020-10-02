package br.edu.unijuazeiro.unidelivery.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_product")
    @SequenceGenerator(sequenceName = "seq_product", allocationSize = 1, 
        initialValue = 10, name = "gen_product")
    private Integer code;

    private String name;
    
    private Double price;

}
