package com.poo.hotel.poo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PooApplication {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Quarto.gerarQuartos();
        Cliente.gerarClientes();
        Reserva.gerarReservas();

         
            exibirMenuInicial();
        
    }

        public static void limpa_windows() {
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.println("Este comando só funciona no Windows.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    private static void exibirMenuInicial() {

        boolean repete = true;
        
        System.out.println("###########################################");
        System.out.println("###                                     ###");
        System.out.println("###         BEM VINDO AO HOTEL HABBO    ###");
        System.out.println("###                                     ###");
        System.out.println("###########################################");

        while(repete){ 

        limpa_windows();
        System.out.println();
        System.out.println("### MENU INICIAL ###");
        System.out.println("1. Menu Visitante");
        System.out.println("2. Menu Funcionário");
        System.out.println("3. Menu Gestor");
        System.out.println("4. Cadastro de Usuário");
        System.out.println("5. Sair");
        System.out.println();
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
                MenuGestor menuGestor = new MenuGestor();
                menuGestor.exibirMenu();
                break;
            case 4:
                cadastrarUsuario();
                break;
            case 5:
                // Reserva.listarReservas();
                System.out.println("Saindo do sistema...");
                repete = false;
                break;
            case 6:

                break;
            default:
                System.out.println("Opção inválida!");
                break;
            }
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