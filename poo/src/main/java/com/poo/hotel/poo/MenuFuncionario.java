package com.poo.hotel.poo;

import java.util.*;

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

        if (Autenticacao.autenticar(login, senha, "funcionario")) {
            System.out.println("Login realizado com sucesso!");
            exibirOpcoesFuncionario();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    private void exibirOpcoesFuncionario() {
        while (true) {
            System.out.println("### MENU FUNCIONÁRIO ###");
            System.out.println("1. Lançar Serviços essenciais");
            System.out.println("2. Lançar outro serviço");
            System.out.println("3. Consultar serviços e gastos de um quarto");
            System.out.println("4. Fechar gastos do quarto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
        
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha
            
                switch (opcao) {
                    case 1:
                        lancarServicosEssenciais();
                        break;
                    case 2:
                        lancarOutroServico();
                        break;
                    case 3:
                        consultarServicosGastosQuarto();
                        break;
                    case 4:
                        fecharGastosQuarto();
                        break;
                    case 5:
                        System.out.println("Saindo do menu funcionário...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.nextLine();  // Limpar a entrada inválida
            }
        }
    }

    private void lancarServicosEssenciais() {
        System.out.println("### LANÇAR SERVIÇOS ESSENCIAIS ###");
        System.out.println("Serviços essenciais disponíveis:");
        System.out.println("1. Café da manhã");
        System.out.println("2. Limpeza");
        System.out.println("3. Manutenção");
        System.out.print("Escolha o tipo de serviço: ");
        
        String tipoServico = null;
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                tipoServico = "Café da manhã";
                break;
            case 2:
                tipoServico = "Limpeza";
                break;
            case 3:
                tipoServico = "Manutenção";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        ServicoQuarto servicoQuarto = new ServicoQuarto(tipoServico, 0, numeroQuarto); // Valor padrão 0
        BancoDeDados.adicionarServicoQuarto(servicoQuarto);

        System.out.println("Serviço essencial lançado com sucesso: " + servicoQuarto);

        retornarAoMenu();
    }

    private void lancarOutroServico() {
        System.out.println("### LANÇAR OUTRO SERVIÇO ###");
        System.out.print("Digite a descrição do serviço: ");
        String tipoServico = scanner.nextLine();

        System.out.print("Digite o valor do serviço: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Consumir a quebra de linha
        
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        ServicoQuarto servicoQuarto = new ServicoQuarto(tipoServico, valor, numeroQuarto);
        BancoDeDados.adicionarServicoQuarto(servicoQuarto);

        System.out.println("Outro serviço lançado com sucesso: " + servicoQuarto);

        retornarAoMenu();
    }

    private void consultarServicosGastosQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        List<ServicoQuarto> servicos = BancoDeDados.obterServicosPorQuarto(numeroQuarto);
        double totalGastos = 0;

        System.out.println("### SERVIÇOS DO QUARTO " + numeroQuarto + " ###");
        for (ServicoQuarto servico : servicos) {
            System.out.println(servico);
            totalGastos += servico.getValor();
        }
        System.out.println("Total de gastos: " + totalGastos);

        retornarAoMenu();
    }

    private void fecharGastosQuarto() {
        System.out.print("Digite o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        double totalGastos = BancoDeDados.obterTotalGastosPorQuarto(numeroQuarto);

        if (totalGastos > 0) {
            System.out.println("Total de gastos do quarto " + numeroQuarto + ": " + totalGastos);
            System.out.print("Deseja fechar os gastos e liberar o quarto? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                BancoDeDados.removerServicosPorQuarto(numeroQuarto);
                System.out.println("Gastos fechados e quarto liberado.");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Não há gastos para este quarto.");
        }

        retornarAoMenu();
    }

    private void retornarAoMenu() {
        System.out.println("Pressione Enter para retornar ao menu.");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        menuFuncionario.exibirMenu();
    }
}
