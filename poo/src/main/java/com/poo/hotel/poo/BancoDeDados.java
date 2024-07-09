package com.poo.hotel.poo;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static List<Quarto> quartos = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static List<Avaliacao> avaliacoesAtendimento = new ArrayList<>();
    private static List<Avaliacao> avaliacoesQualidadeHospedagem = new ArrayList<>();
    private static List<ServicoQuarto> servicosQuarto = new ArrayList<>();

    static {
        // Inicializa alguns quartos para teste
        quartos.add(new Quarto(101));
        quartos.add(new Quarto(102));
        quartos.add(new Quarto(103));
    }

    public static List<Quarto> getQuartos() {
        return quartos;
    }

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static void adicionarAvaliacaoAtendimento(Avaliacao avaliacao) {
        avaliacoesAtendimento.add(avaliacao);
    }

    public static void adicionarAvaliacaoQualidadeHospedagem(Avaliacao avaliacao) {
        avaliacoesQualidadeHospedagem.add(avaliacao);
    }

    public static void adicionarServicoQuarto(ServicoQuarto servicoQuarto) {
        servicosQuarto.add(servicoQuarto);
    }

    public static double calcularFaturamento() {
        // Supondo que cada reserva tem um valor fixo, por exemplo, 200.0
        double faturamento = 0;
        for (Reserva reserva : reservas) {
            faturamento += 200.0;
        }
        return faturamento;
    }

    public static double calcularNivelVacancia() {
        int totalQuartos = quartos.size();
        int quartosVagos = 0;
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                quartosVagos++;
            }
        }
        return ((double) quartosVagos / totalQuartos) * 100;
    }

    public static String calcularDiasMenorVacancia() {
        // Esta é uma implementação simplificada. Em um sistema real, haveria uma análise mais detalhada.
        return "Segunda, Terça e quarto";
    }

    public static String obterIndicadoresDesempenho() {
        // Esta é uma implementação simplificada. Em um sistema real, haveria uma análise mais detalhada.
        return "Taxa de ocupação: 75%\nNível de satisfação: 4.5/5";
    }
}
