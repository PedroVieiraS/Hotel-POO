package com.poo.hotel.poo;

class ServicoQuarto {
    private String tipoServico;
    private double valor;
    private int numeroQuarto;

    public ServicoQuarto(String tipoServico, double valor, int numeroQuarto) {
        this.tipoServico = tipoServico;
        this.valor = valor;
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public double getValor() {
        return valor;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipoServico + ", Valor: " + valor + ", Quarto: " + numeroQuarto;
    }
}

