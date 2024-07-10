package com.poo.hotel.poo;

class ServicoQuarto {
    private String descricao;
    private boolean realizado;

    public ServicoQuarto(String descricao) {
        this.descricao = descricao;
        this.realizado = false;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    // Método
    public void realizar() {
        this.realizado = true;
    }
}

