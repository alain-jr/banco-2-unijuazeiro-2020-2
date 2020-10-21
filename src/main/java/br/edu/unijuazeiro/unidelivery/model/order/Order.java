package br.edu.unijuazeiro.unidelivery.model.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gets and sets
@NoArgsConstructor // construtor sem argumentos
@Entity(name = "tb_order")
public class Order {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_order")
    @SequenceGenerator(sequenceName = "seq_order", allocationSize = 1, initialValue = 1, name = "gen_order")
    private Long code;

    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    public void sumTotal() {
        total = 0.0;
        for (Item item : items) {
            try {
                total += item.getQuantity() * item.getProduct().getPrice();
            } catch (NullPointerException e) {
                // TODO: handle exception
            }
        }
    }

}