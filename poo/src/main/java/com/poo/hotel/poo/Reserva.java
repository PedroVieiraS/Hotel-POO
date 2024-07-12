package com.poo.hotel.poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate checkIn) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.checkIn = checkIn;  
    }

    public Reserva(Cliente cliente, Quarto quarto, LocalDate checkIn, LocalDate checkOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.checkIn = checkIn;  
        this.checkOut = checkOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static void removerReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public static Reserva buscarReserva(Cliente cliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente)) {
                return reserva;
            }
        }
        return null;
    }

    public static Reserva buscarReserva(Quarto quarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().equals(quarto)) {
                return reserva;
            }
        }
        return null;
    }

    public static Reserva buscarReserva(LocalDate checkIn) {
        for (Reserva reserva : reservas) {
            if (reserva.getCheckIn().equals(checkIn)) {
                return reserva;
            }
        }
        return null;
    }

    public static void gerarReservas() {
        Reserva.adicionarReserva(new Reserva(Cliente.getClientes().get(0), Quarto.getQuartos().get(0), LocalDate.of(2024, 7, 1)));
        Reserva.adicionarReserva(new Reserva(Cliente.getClientes().get(1), Quarto.getQuartos().get(1), LocalDate.of(2024, 7, 2)));
        Reserva.adicionarReserva(new Reserva(Cliente.getClientes().get(2), Quarto.getQuartos().get(2), LocalDate.of(2024, 7, 3)));
        Reserva.adicionarReserva(new Reserva(Cliente.getClientes().get(3), Quarto.getQuartos().get(3), LocalDate.of(2024, 7, 4)));
        Reserva.adicionarReserva(new Reserva(Cliente.getClientes().get(4), Quarto.getQuartos().get(4), LocalDate.of(2024, 7, 5)));
    }
    
    public static void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas realizadas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("Cliente: " + reserva.getCliente().getNome() + 
                                   ", Quarto: " + reserva.getQuarto().getNumero() + 
                                   ", Check-in: " + reserva.getCheckIn() + 
                                   ", Check-out: " + (reserva.getCheckOut() != null ? reserva.getCheckOut() : "Ainda hospedado"));
            }
        }
    }
}
