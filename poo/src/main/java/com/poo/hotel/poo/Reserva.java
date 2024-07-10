package com.poo.hotel.poo;
import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataReserva;

    public Reserva(Cliente cliente, Quarto quarto) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataReserva = LocalDate.now();
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }
}
