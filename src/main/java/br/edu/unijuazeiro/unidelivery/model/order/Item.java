package br.edu.unijuazeiro.unidelivery.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.unidelivery.model.product.Product;
import lombok.Data;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_item")
    @SequenceGenerator(sequenceName = "seq_item", allocationSize = 1, initialValue = 1, name = "gen_item")
    private Long code;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private Double quantity;

}
