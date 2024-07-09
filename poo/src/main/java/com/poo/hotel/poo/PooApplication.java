package com.poo.hotel.poo;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PooApplication {
	
	public class LimpaTerminal {
		static void limpa_windows() {
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

	}
	
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenuInicial();
        }
    }

    private static void exibirMenuInicial() {
        System.out.println("### MENU INICIAL ###");
        System.out.println("1. Menu Visitante");
        System.out.println("2. Menu Funcionário");
        System.out.println("3. Menu Gestor");
        System.out.println("4. Sair");
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
                System.out.println("Saindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

}
