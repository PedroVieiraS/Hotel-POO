package com.poo.hotel.poo;

public class Quarto {
    
    int quarto;
    int banheiro;
    int limpeza;
    int localidade;
    int cafe;
    int atendimento;
    
    private int numero;
    private boolean disponivel;

    public Quarto(int numero, int banheiro, int limpeza, int localidade, int cafe, int atendimento) {
        this.numero = numero;
        this.disponivel = true;
        this.quarto = quarto;
        this.banheiro = banheiro;
        this.limpeza = limpeza;
        this.localidade = localidade;
        this.cafe = cafe;
        this.atendimento = atendimento;
    }


    public int getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(int banheiro) {
        this.banheiro = banheiro;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
    }

    public int getLocalidade() {
        return localidade;
    }

    public void setLocalidade(int localidade) {
        this.localidade = localidade;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(int atendimento) {
        this.atendimento = atendimento;
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
