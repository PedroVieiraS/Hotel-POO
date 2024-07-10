package com.poo.hotel.poo;
import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private Date dataInicio;
    private Date dataFim;

    public Reserva(Cliente cliente, Quarto quarto, Date dataInicio, Date dataFim) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
}