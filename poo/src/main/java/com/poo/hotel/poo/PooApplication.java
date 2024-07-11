package com.poo.hotel.poo;

import java.util.Scanner;

public class PooApplication {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenuInicial();
        }
    }

    private static void exibirMenuInicial() {
        System.out.println("### Bem vindo ao Hotel Senai ###");
        System.out.println("### MENU INICIAL ###");
        System.out.println("1. Menu Visitante");
        System.out.println("2. Menu Funcionário");
        System.out.println("3. Menu Gestor");
        System.out.println("4. Cadastro de Usuário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                MenuVisitante menuVisitante = new MenuVisitante();
                menuVisitante.exibirMenu();
                break;
            case 2:
                MenuFuncionario menuFuncionario = new MenuFuncionario();
                menuFuncionario.exibirMenu();
                break;
            case 3:
                // Corrigindo a criação do MenuGestor
                MenuGestor menuGestor = new MenuGestor(null); // Aqui você deve passar a lista de avaliações
                menuGestor.exibirMenu();
                break;
            case 4:
                cadastrarUsuario();
                break;
            case 5:
                System.out.println("Saindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o login do novo usuário: ");
        String login = scanner.nextLine();
        System.out.print("Digite a senha do novo usuário: ");
        String senha = scanner.nextLine();
        System.out.print("Digite o tipo de usuário (visitante/funcionario/gestor): ");
        String tipoUsuario = scanner.nextLine();

        if (Login.cadastrarUsuario(login, senha, tipoUsuario)) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Falha no cadastro do usuário.");
        }
    }
}
