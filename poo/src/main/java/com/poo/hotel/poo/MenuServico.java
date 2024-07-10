package com.poo.hotel.poo;

import java.util.Scanner;

public class MenuServico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            exibirMenuServicos();
            String opcao = scanner.nextLine();
            if (opcao.equals("0")) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                lancarServico(opcao, scanner);
            }
        }
        scanner.close();
    }

    public static void exibirMenuServicos() {
        System.out.println("Menu Serviço");
        System.out.println("1. Café da manhã");
        System.out.println("2. Limpeza");
        System.out.println("3. Lavanderia");
        System.out.println("4. Manutenção");
        System.out.println("0. Sair");
        System.out.print("Selecione uma opção: ");
    }

    public static void lancarServico(String opcao, Scanner scanner) {
        String descricao;
        switch (opcao) {
            case "1":
                descricao = "Café da manhã";
                break;
            case "2":
                descricao = "Limpeza";
                break;
            case "3":
                descricao = "Lavanderia";
                break;
            case "4":
                descricao = "Manutenção";
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        ServicoQuarto servico = new ServicoQuarto(descricao);
        System.out.println("Você selecionou: " + servico.getDescricao());
        System.out.print("Confirmar lançamento do serviço? (s/n): ");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("s")) {
            servico.realizar();
            System.out.println("Serviço lançado com sucesso!");
        } else {
            System.out.println("Lançamento cancelado.");
        }
    }

    @Override
    public String toString() {
        return "MenuServico []";
    }
}