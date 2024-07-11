package com.poo.hotel.poo;

public class ServicoQuarto {
    private String descricao;
    private double valor;
    private Reserva reserva;

    public ServicoQuarto(String descricao, double valor, Reserva reserva) {
        this.descricao = descricao;
        this.valor = valor;
        this.reserva = reserva;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}