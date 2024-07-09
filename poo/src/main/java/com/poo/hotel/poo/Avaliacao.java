package com.poo.hotel.poo;

public class Avaliacao {
    private int avaliacao;
    private String comentario;

    public Avaliacao(int avaliacao, String comentario) {
        this.avaliacao = avaliacao;
        this.comentario = comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }
}
