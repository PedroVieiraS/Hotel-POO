package com.poo.hotel.poo;

public class Quarto {
    private int numero;
    private boolean disponivel;

    public Quarto(int numero) {
        this.numero = numero;
        this.disponivel = true;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Métodos
    public void reservar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

}
