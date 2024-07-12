package com.poo.hotel.poo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuGestor {
    private Scanner scanner;

    public MenuGestor() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (Login.autenticar(login, senha, "gestor")) {
            System.out.println("Login realizado com sucesso!");
            exibirOpcoesGestor();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    private void exibirOpcoesGestor() {
        System.out.println("### MENU GESTOR ###");
        System.out.println("1. Verificar faturamento do hotel");
        System.out.println("2. Verificar nível de vacância");
        System.out.println("3. Verificar dias da semana de menor vacância");
        System.out.println("4. Verificar indicadores de desempenho");
        System.out.println("5. Ver reservas realizadas");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                verificarFaturamento();
                break;
            case 2:
                verificarVacancia();
                break;
            case 3:
                verificarDiasMenorVacancia();
                break;
            case 4:
                verificarIndicadoresDesempenho();
                break;
            case 5:
                Reserva.listarReservas();
                break;
            case 6:
                System.out.println("Saindo do menu gestor...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void verificarFaturamento() {
        System.out.println("### VERIFICAR FATURAMENTO DO HOTEL ###");

        double precoPorDia = 100.0; // Exemplo de preço fixo por dia
        double faturamentoTotal = 0.0;

        for (Reserva reserva : Reserva.getReservas()) {
            LocalDate checkOut = reserva.getCheckOut() != null ? reserva.getCheckOut() : LocalDate.now();
            long diasHospedados = reserva.getCheckIn().until(checkOut).getDays();
            faturamentoTotal += diasHospedados * precoPorDia;
        }

        System.out.println("Faturamento total do hotel: R$ " + faturamentoTotal);
    }

    private void verificarVacancia() {
        System.out.println("### VERIFICAR NÍVEL DE VACÂNCIA ###");

        int totalQuartos = BancoDeDados.getQuartos().size();
        int quartosOcupados = 0;

        for (Quarto quarto : BancoDeDados.getQuartos()) {
            if (!Quarto.verificarDisponibilidade(quarto)) {
                quartosOcupados++;
            }
        }

        int quartosVagos = totalQuartos - quartosOcupados;
        double taxaVacancia = ((double) quartosVagos / totalQuartos) * 100;

        System.out.println("Total de quartos: " + totalQuartos);
        System.out.println("Quartos ocupados: " + quartosOcupados);
        System.out.println("Quartos vagos: " + quartosVagos);
        System.out.println("Taxa de vacância: " + taxaVacancia + "%");
    }

    private void verificarDiasMenorVacancia() {
        System.out.println("### VERIFICAR DIAS DA SEMANA DE MENOR VACÂNCIA ###");

        Map<DayOfWeek, Integer> ocupacaoPorDia = new HashMap<>();

        for (DayOfWeek dia : DayOfWeek.values()) {
            ocupacaoPorDia.put(dia, 0);
        }

        for (Reserva reserva : Reserva.getReservas()) {
            LocalDate checkOut = reserva.getCheckOut() != null ? reserva.getCheckOut() : LocalDate.now();
            LocalDate data = reserva.getCheckIn();

            while (!data.isAfter(checkOut)) {
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                ocupacaoPorDia.put(diaDaSemana, ocupacaoPorDia.get(diaDaSemana) + 1);
                data = data.plusDays(1);
            }
        }

        DayOfWeek diaMenorVacancia = null;
        int menorOcupacao = Integer.MAX_VALUE;

        for (Map.Entry<DayOfWeek, Integer> entry : ocupacaoPorDia.entrySet()) {
            if (entry.getValue() < menorOcupacao) {
                menorOcupacao = entry.getValue();
                diaMenorVacancia = entry.getKey();
            }
        }

        System.out.println("Dia da semana com menor vacância: " + diaMenorVacancia + " com " + menorOcupacao + " quartos ocupados.");
    }

    private void verificarIndicadoresDesempenho() {
        System.out.println("### VERIFICAR INDICADORES DE DESEMPENHO ###");

        verificarFaturamento();
        verificarVacancia();
        verificarDiasMenorVacancia();
    }
}
