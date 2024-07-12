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

    public static List<Quarto> getQuartos() {
        return quartos;
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    private static List<ServicoQuarto> servicos = new ArrayList<>();

    public static void adicionarServicoQuarto(ServicoQuarto servicoQuarto) {
        servicos.add(servicoQuarto);
        System.out.println("Serviço adicionado ao banco de dados: " + servicoQuarto);
    }

    public static List<ServicoQuarto> obterServicosPorQuarto(int numeroQuarto) {
        List<ServicoQuarto> servicosQuarto = new ArrayList<>();
        for (ServicoQuarto servico : servicos) {
            if (servico.getNumeroQuarto() == numeroQuarto) {
                servicosQuarto.add(servico);
            }
        }
        return servicosQuarto;
    }

    public static double obterTotalGastosPorQuarto(int numeroQuarto) {
        double total = 0;
        for (ServicoQuarto servico : servicos) {
            if (servico.getNumeroQuarto() == numeroQuarto) {
                total += servico.getValor();
            }
        }
        return total;
    }

    public static void removerServicosPorQuarto(int numeroQuarto) {
        servicos.removeIf(servico -> servico.getNumeroQuarto() == numeroQuarto);
   
   }
}