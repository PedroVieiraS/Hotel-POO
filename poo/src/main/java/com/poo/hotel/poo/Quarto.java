package com.poo.hotel.poo;
import java.util.ArrayList;


public class Quarto {
    private static ArrayList<Quarto> quartos = new ArrayList<>();

    private int numero;
    private boolean estaLimpo;

    public Quarto(int numero) {
        this.numero = numero;
        this.estaLimpo = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getEstaLimpo() {
        return estaLimpo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstaLimpo(boolean estaLimpo) {
        this.estaLimpo = estaLimpo;
    }

    public static ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public static void gerarQuartos() {       
        for (int i = 0; i < 10; i++) {
            Quarto quarto = new Quarto(i + 1);
            quartos.add(quarto);
            BancoDeDados.adicionarQuarto(quarto);  // Adiciona os quartos ao BancoDeDados
        }
    }

    public static boolean verificarDisponibilidade(Quarto quarto) {
        Reserva reservaMaisRecente = null;

        for (Reserva reserva : Reserva.getReservas()) {
            if (reserva.getQuarto().equals(quarto)) {
                if (reservaMaisRecente == null || reserva.getCheckIn().isAfter(reservaMaisRecente.getCheckIn())) {
                    reservaMaisRecente = reserva;
                }
            }
        }

        return reservaMaisRecente == null || reservaMaisRecente.getCheckOut() != null;
    }

    @Override
    public String toString() {
        return "Quarto numero: " + numero +
               ". Estado: " + estaLimpo;
    }
}
