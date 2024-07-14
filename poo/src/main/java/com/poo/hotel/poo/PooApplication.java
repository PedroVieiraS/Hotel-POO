package com.poo.hotel.poo;
import java.util.*;

public class PooApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static Cliente clienteLogado = null;

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            if (clienteLogado == null) {
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Realizar reserva");
                System.out.println("2. Avaliar atendimento");
                System.out.println("3. Avaliar hospedagem");
                System.out.println("4. Acessar conta de cliente");
                System.out.println("5. Menu de Serviços");
                System.out.println("6. Menu Gestor");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
            } else {
                System.out.println("\n=== Menu do Cliente ===");
                System.out.println("1. Ver reservas");
                System.out.println("2. Ver avaliações feitas");
                System.out.println("3. Sair da conta de cliente");
                System.out.print("Escolha uma opção: ");
            }

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (clienteLogado == null) {
                switch (opcao) {
                    case 1:
                        BancoDeDados.realizarReserva();
                        break;
                    case 2:
                        BancoDeDados.avaliarAtendimento();
                        break;
                    case 3:
                        BancoDeDados.avaliarHospedagem();
                        break;
                    case 4:
                        BancoDeDados.loginCliente();
                        break;
                    case 5:
                        BancoDeDados.loginServico();
                        break;
                    case 6:
                        BancoDeDados.loginGestor();
                        break;
                    case 7:
                        sair = true;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                switch (opcao) {
                    case 1:
                        BancoDeDados.verReservasCliente();
                        break;
                    case 2:
                        BancoDeDados.verAvaliacoesCliente();
                        break;
                    case 3:
                        clienteLogado = null;
                        System.out.println("Saindo da conta de cliente...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    public static void exibirMenuServicos() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu de Serviços ===");
            System.out.println("1. Lançar serviço de quarto");
            System.out.println("2. Verificar serviços de quarto lançados");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    BancoDeDados.lancarServicoQuarto();
                    break;
                case 2:
                    BancoDeDados.verificarServicosQuarto();
                    break;
                case 3:
                    sair = true;
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    } 

    public static void exibirMenuGestor() {
        System.out.println("### MENU GESTOR ###");
        System.out.println("1. Verificar faturamento do hotel");
        System.out.println("2. Verificar nível de vacância");
        System.out.println("3. Verificar dias da semana de menor vacância");
        System.out.println("4. Verificar indicadores de desempenho");
        System.out.println("5. Ver reservas realizadas");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                //BancoDeDados.verificarFaturamento();
                break;
            case 2:
                //BancoDeDados.verificarVacancia();
                break;
            case 3:
                //BancoDeDados.verificarDiasMenorVacancia();
                break;
            case 4:
                //BancoDeDados.verificarIndicadoresDesempenho();
                break;
            case 5:
                Reserva.getReservas();
                break;
            case 6:
                System.out.println("Saindo do menu gestor...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

}