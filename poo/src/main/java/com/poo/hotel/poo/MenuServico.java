package com.poo.hotel.poo;

import java.util.Scanner;

public class MenuServico {
    
    private Scanner scanner;
    
    public MenuServico() {
        this.scanner = new Scanner(System.in);
    }

    public boolean exibirMenu() {
        while (true) {
            exibirMenuServicos();
            String opcao = scanner.nextLine();
            if (opcao.equals("0")) {
                System.out.println("Saindo do sistema...");
                return true; // Indica que o usuário escolheu sair
            } else {
                if (lancarServico(opcao, scanner)) {
                    return true; // Indica que o usuário confirmou o serviço
                }
            }
        }
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

    public boolean lancarServico(String opcao, Scanner scanner) {
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
                return false; // Retorna falso se a opção for inválida
        }

        ServicoQuarto servico = new ServicoQuarto(descricao);
        System.out.println("Você selecionou: " + servico.getDescricao());
        System.out.print("Confirmar lançamento do serviço? (s/n): ");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("s")) {
            servico.realizar();
            BancoDeDados.adicionarServicoQuarto(servico);
            System.out.println("Serviço lançado com sucesso!");
            return true; // Retorna verdadeiro se o serviço foi confirmado
        } else {
            System.out.println("Lançamento cancelado.");
            return false; // Retorna falso se o serviço não foi confirmado
        }
    }

    @Override
    public String toString() {
        return "MenuServico []";
    }
}
