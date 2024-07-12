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
        System.out.println("### MENU FUNCIONÁRIO ###");
        System.out.println("1. Lançar serviço de quarto");
        System.out.println("2. Alocar Visitante em Quarto");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  

        switch (opcao) {
            case 1:
                lancarServicoQuarto();
                break;
            case 2:
                System.out.println("Saindo do menu funcionário...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }



    private void lancarServicoQuarto() {
        System.out.println("### LANÇAR SERVIÇO DE QUARTO ###");
        System.out.print("Digite a descrição do serviço: ");
        String descricao = scanner.nextLine();

        ServicoQuarto servicoQuarto = new ServicoQuarto(descricao);
        BancoDeDados.adicionarServicoQuarto(servicoQuarto);

        System.out.println("Serviço de quarto lançado com sucesso: " + descricao);
    }
}
