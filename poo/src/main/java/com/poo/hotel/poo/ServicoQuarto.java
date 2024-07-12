package com.poo.hotel.poo;

public class ServicoQuarto {
    private String descricao;
    private boolean realizado;

    public ServicoQuarto(String descricao) {
        this.descricao = descricao;
        this.realizado = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void realizar() {
        this.realizado = true;
    }
}
