package com.poo.hotel.poo;

import java.util.Scanner;

public class MenuFuncionario {
    private Scanner scanner;

    public MenuFuncionario() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (Login.autenticar(login, senha, "funcionario")) {
            System.out.println("Login realizado com sucesso!");
            exibirOpcoesFuncionario();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    private void exibirOpcoesFuncionario() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("### MENU FUNCIONÁRIO ###");
            System.out.println("1. Lançar serviço de quarto");
            System.out.println("2. Ver reservas realizadas");
            System.out.println("3. Tipo de serviço de quarto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    boolean sucesso = lancarServicoQuarto();
                    if (sucesso) {
                        System.out.println("Serviço de quarto lançado com sucesso!");
                    } else {
                        System.out.println("Erro ao lançar serviço de quarto.");
                    }
                    break;
                case 2:
                    Reserva.listarReservas();
                    break;
                case 3:
                    MenuServico menuServico = new MenuServico();
                    menuServico.exibirMenu();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do menu funcionário...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        System.out.println("Encerrando menu funcionário...");
    }

    private boolean lancarServicoQuarto() {
        System.out.println("### LANÇAR SERVIÇO DE QUARTO ###");
        System.out.print("Digite a descrição do serviço: ");
        String descricao = scanner.nextLine();

        // Simulação de lançamento do serviço de quarto
        try {
            // Lógica para adicionar o serviço de quarto ao banco de dados (simulado)
            BancoDeDados.adicionarServicoQuarto(new ServicoQuarto(descricao));
            System.out.println("Serviço de quarto lançado com sucesso: " + descricao);
            return true; // Retorna true se o serviço foi lançado com sucesso
        } catch (Exception e) {
            System.out.println("Erro ao lançar serviço de quarto: " + e.getMessage());
            return false; // Retorna false se houve algum problema ao lançar o serviço
        }
    }
}
