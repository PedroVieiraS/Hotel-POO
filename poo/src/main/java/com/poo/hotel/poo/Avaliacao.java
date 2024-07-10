package com.poo.hotel.poo;

public class Avaliacao {
    private int atendimento;
    private int qualidadeCama;
    private int qualidadeBanheiro;
    private int limpeza;
    private int localizacao;

    public Avaliacao(int atendimento, int qualidadeCama, int qualidadeBanheiro, int limpeza, int localizacao) {
        this.atendimento = atendimento;
        this.qualidadeCama = qualidadeCama;
        this.qualidadeBanheiro = qualidadeBanheiro;
        this.limpeza = limpeza;
        this.localizacao = localizacao;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public int getQualidadeCama() {
        return qualidadeCama;
    }

    public int getQualidadeBanheiro() {
        return qualidadeBanheiro;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public int getLocalizacao() {
        return localizacao;
    }
}