package com.poo.hotel.poo;
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
        System.out.println("5. Sair");
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
                System.out.println("Saindo do menu gestor...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void verificarFaturamento() {
        System.out.println("### VERIFICAR FATURAMENTO DO HOTEL ###");

    }

    private void verificarVacancia() {
        System.out.println("### VERIFICAR NÍVEL DE VACÂNCIA ###");

    }

    private void verificarDiasMenorVacancia() {
        System.out.println("### VERIFICAR DIAS DA SEMANA DE MENOR VACÂNCIA ###");

    }

    private void verificarIndicadoresDesempenho() {
        System.out.println("### VERIFICAR INDICADORES DE DESEMPENHO ###");

    }
}
