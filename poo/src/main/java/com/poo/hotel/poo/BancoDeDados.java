package com.poo.hotel.poo;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    public static List<Quarto> quartos = new ArrayList<>();
    public static List<Reserva> reservas = new ArrayList<>();
    public static List<ServicoQuarto> servicosQuarto = new ArrayList<>();

    public static void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static void adicionarServicoQuarto(ServicoQuarto servicoQuarto) {
        servicosQuarto.add(servicoQuarto);
    }

    public static List<Quarto> getQuartos() {
        return quartos;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    public static List<ServicoQuarto> getServicosQuarto() {
        return servicosQuarto;
    }
}
