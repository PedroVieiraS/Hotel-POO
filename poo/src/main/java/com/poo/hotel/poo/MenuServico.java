package com.poo.hotel.poo;

import java.util.Scanner;

public class MenuServico {
    private Scanner scanner;

    public MenuServico() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("### MENU SERVIÇO ###");
            System.out.println("1. Café da manhã - R$ 30.00");
            System.out.println("2. Limpeza - R$ 50.00");
            System.out.println("3. Lavanderia - R$ 40.00");
            System.out.println("4. Manutenção - R$ 70.00");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    lancarServico("Café da manhã", 30.0);
                    break;
                case 2:
                    lancarServico("Limpeza", 50.0);
                    break;
                case 3:
                    lancarServico("Lavanderia", 40.0);
                    break;
                case 4:
                    lancarServico("Manutenção", 70.0);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saindo do menu serviço...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void lancarServico(String descricao, double custo) {
        ServicoQuarto servico = new ServicoQuarto(descricao, custo);
        System.out.println("Você selecionou: " + servico.getDescricao() + " por R$ " + servico.getCusto());
        System.out.print("Confirmar lançamento do serviço? (s/n): ");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("s")) {
            BancoDeDados.adicionarServicoQuarto(servico);
            System.out.println("Serviço lançado com sucesso!");
            System.out.println();
        } else {
            System.out.println("Lançamento cancelado.");
            System.out.println();
        }
    }
}
