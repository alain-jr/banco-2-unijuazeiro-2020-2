package br.edu.unijuazeiro.unidelivery;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // gets and sets
@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // construtor com todos argumentos com base nos atributos da classe
@Entity // indica que essa classe representa uma ENTIDADE
public class Customer {

    @Id // indica que CODE é o campo chave-primária
    private Integer code;

    private String name;

}
