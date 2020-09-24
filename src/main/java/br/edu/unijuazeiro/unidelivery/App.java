package br.edu.unijuazeiro.unidelivery;

import javax.persistence.Persistence;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("Primeira Conexao: " + Persistence.createEntityManagerFactory("unit-unijuazeiro"));
    }
}