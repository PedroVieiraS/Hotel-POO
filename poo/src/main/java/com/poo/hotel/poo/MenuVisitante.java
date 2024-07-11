package com.poo.hotel.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuVisitante {
    
    private Scanner scanner;
    private ArrayList <AvaliacaoQualidade> avaliacoes;

	private boolean disponivel;


    //  MÉTODOS

    public boolean isDisponivel() {
		return disponivel;
	}


    public MenuVisitante() {
        this.scanner = new Scanner(System.in);
        this.avaliacoes = new ArrayList<>(); 
    }

    public void exibirMenu() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (Login.autenticar(login, senha, "visitante")) {
            System.out.println("Login realizado com sucesso!");
            exibirOpcoesVisitante();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    private void exibirOpcoesVisitante() {
        System.out.println("### MENU VISITANTE ###");
        System.out.println("1. Realizar reserva");
        System.out.println("2. Avaliar atendimento");
        System.out.println("3. Avaliar qualidade da hospedagem");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                realizarReserva();
                break;
            case 2:
                avaliarAtendimento();
                break;
            case 3:
                avaliarQualidadeHospedagem();
                break;
            case 4:
                System.out.println("Saindo do menu visitante...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private Quarto selecionarQuartoDisponivel() {
        for (Quarto quarto : BancoDeDados.getQuartos()) {
            if (isDisponivel()) {
                return quarto;
            }
        }
        return null;
    }

    private void avaliarAtendimento() {
        System.out.println("### AVALIAR ATENDIMENTO ###");

        System.out.print("Avalie o atendimento de 1 a 10: ");
        int atendimento = scanner.nextInt();
        scanner.nextLine();

        AvaliacaoQualidade avaliacao = new AvaliacaoQualidade(0, 0, 0, 0, 0, atendimento);
        avaliacoes.add(avaliacao);

        System.out.println("Avaliação de atendimento registrada com sucesso!");
    }

    private void avaliarQualidadeHospedagem() {
        System.out.println("### AVALIAR QUALIDADE DA HOSPEDAGEM ###");

        System.out.print("Avalie o quarto de 1 a 10: ");
        int quarto = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Avalie o banheiro de 1 a 10: ");
        int banheiro = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Avalie a limpeza de 1 a 10: ");
        int limpeza = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Avalie a localidade de 1 a 10: ");
        int localidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Avalie o café da manhã de 1 a 10: ");
        int cafe = scanner.nextInt();
        scanner.nextLine();

        AvaliacaoQualidade avaliacao = new AvaliacaoQualidade(quarto, banheiro, limpeza, localidade, cafe, 0);
        avaliacoes.add(avaliacao);

        System.out.println("Avaliações de qualidade da hospedagem registradas com sucesso!");
    }
    
}