package com.poo.hotel.poo;
import java.text.SimpleDateFormat;
import java.util.*;

public class PooApplication {
    private static BancoDeDados bancoDeDados = new BancoDeDados();
    private static Scanner scanner = new Scanner(System.in);
    private static Cliente clienteLogado = null;

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
                System.out.println("5. Área Administrativa");
                System.out.println("6. Sair");
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
                        realizarReserva();
                        break;
                    case 2:
                        avaliarAtendimento();
                        break;
                    case 3:
                        avaliarHospedagem();
                        break;
                    case 4:
                        loginCliente();
                        break;
                    case 5:
                        loginAdmin();
                        break;
                    case 6:
                        sair = true;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                switch (opcao) {
                    case 1:
                        verReservasCliente();
                        break;
                    case 2:
                        verAvaliacoesCliente();
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

    private static void realizarReserva() {
        System.out.print("\nDigite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        if (!validarCpf(cpf)) {
            System.out.println("CPF inválido. Reserva não pode ser realizada.");
            return;
        }

        Cliente cliente = bancoDeDados.buscarClientePorCpf(cpf);
        if (cliente == null) {
            cliente = new Cliente(nome, cpf);
            bancoDeDados.adicionarCliente(cliente);
        }

        // Mostrar os tipos de quartos disponíveis
        List<Quarto> quartosDisponiveis = bancoDeDados.getQuartosDisponiveis();
        System.out.println("\nTipos de quartos disponíveis:");
        for (Quarto quarto : quartosDisponiveis) {
            System.out.println(quarto.getNumero() + ". " + quarto.getTipo());
        }
        System.out.print("Escolha o número do quarto: ");
        int numeroQuarto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Quarto quartoEscolhido = encontrarQuartoPorNumero(numeroQuarto);
        if (quartoEscolhido == null) {
            System.out.println("Quarto selecionado não está disponível. Reserva não pode ser realizada.");
            return;
        }

        // Solicitar datas de entrada e saída da reserva
        System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
        Date dataInicio = lerData();
        System.out.print("Digite a data de saída (dd/MM/yyyy): ");
        Date dataFim = lerData();

        // Criar a reserva
        Reserva reserva = new Reserva(cliente, quartoEscolhido, dataInicio, dataFim);
        bancoDeDados.adicionarReserva(reserva);
        cliente.adicionarReserva(reserva); // Adicionar reserva ao cliente

        // Marcar o quarto como ocupado
        quartoEscolhido.setOcupado(true);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nReserva realizada com sucesso!");
        System.out.println("Detalhes da reserva:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Quarto: " + quartoEscolhido.getNumero() + " (" + quartoEscolhido.getTipo() + ")");
        System.out.println("Data de entrada: " + dateFormat.format(dataInicio));
        System.out.println("Data de saída: " + dateFormat.format(dataFim));
    }

    private static void avaliarAtendimento() {
        System.out.print("\nDigite seu CPF para avaliar o atendimento: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = bancoDeDados.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Avaliação não pode ser registrada.");
            return;
        }
    
        System.out.println("\n=== Avaliar Atendimento ===");
    
        System.out.print("Avalie o atendimento (de 1 a 5): ");
        int atendimento = lerAvaliacao();
    
        Avaliacao avaliacao = new Avaliacao(atendimento, 0, 0, 0, 0); // Apenas o atendimento é avaliado
        bancoDeDados.adicionarAvaliacao(avaliacao);
        cliente.adicionarAvaliacao(avaliacao); // Adicionar avaliação ao cliente
    
        System.out.println("Avaliação do atendimento realizada com sucesso!");
    }
    
    private static void avaliarHospedagem() {
        System.out.print("\nDigite seu CPF para avaliar a hospedagem: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = bancoDeDados.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Avaliação não pode ser registrada.");
            return;
        }
    
        System.out.println("\n=== Avaliar Hospedagem ===");
    
        System.out.print("Avalie a qualidade da cama (de 1 a 5): ");
        int qualidadeCama = bancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a qualidade do banheiro (de 1 a 5): ");
        int qualidadeBanheiro = bancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a limpeza (de 1 a 5): ");
        int limpeza = bancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a localização (de 1 a 5): ");
        int localizacao = bancoDeDados.lerAvaliacao();
    
        Avaliacao avaliacao = new Avaliacao(0, qualidadeCama, qualidadeBanheiro, limpeza, localizacao); // Apenas a hospedagem é avaliada
        bancoDeDados.adicionarAvaliacao(avaliacao);
        cliente.adicionarAvaliacao(avaliacao); // Adicionar avaliação ao cliente
    
        System.out.println("Avaliação da hospedagem realizada com sucesso!");
    }

    private static void loginCliente() {
        System.out.print("\nDigite seu CPF para login: ");
        String cpf = scanner.nextLine();

        Cliente cliente = bancoDeDados.buscarClientePorCpf(cpf);
        if (cliente != null) {
            clienteLogado = cliente;
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Verifique o CPF digitado.");
        }
    }

    private static void verReservasCliente() {
        System.out.println("\n=== Suas Reservas ===");
        List<Reserva> reservasCliente = bancoDeDados.getReservasCliente(clienteLogado);
        if (reservasCliente.isEmpty()) {
            System.out.println("Você não possui reservas.");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (Reserva reserva : reservasCliente) {
                System.out.println("Quarto: " + reserva.getQuarto().getNumero() + " (" + reserva.getQuarto().getTipo() + ")");
                System.out.println("Data de entrada: " + dateFormat.format(reserva.getDataInicio()));
                System.out.println("Data de saída: " + dateFormat.format(reserva.getDataFim()));
                System.out.println("-------------------------");
            }
        }
    }

    private static void verAvaliacoesCliente() {
        System.out.println("\n=== Suas Avaliações ===");
        List<Avaliacao> avaliacoesCliente = clienteLogado.getAvaliacoes();
        if (avaliacoesCliente.isEmpty()) {
            System.out.println("Você não fez nenhuma avaliação.");
        } else {
            for (Avaliacao avaliacao : avaliacoesCliente) {
                System.out.println("Atendimento: " + avaliacao.getAtendimento());
                System.out.println("Qualidade da cama: " + avaliacao.getQualidadeCama());
                System.out.println("Qualidade do banheiro: " + avaliacao.getQualidadeBanheiro());
                System.out.println("Limpeza: " + avaliacao.getLimpeza());
                System.out.println("Localização: " + avaliacao.getLocalizacao());
                System.out.println("-------------------------");
            }
        }
    }

    private static boolean validarCpf(String cpf) {
        // Implementar validação de CPF
        // Exemplo simplificado: verificar se o CPF possui 11 dígitos
        return cpf.matches("\\d{11}");
    }

    private static Date lerData() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        while (data == null) {
            try {
                String input = scanner.nextLine();
                data = dateFormat.parse(input);
            } catch (Exception e) {
                System.out.println("Formato de data inválido. Digite novamente (dd/MM/yyyy): ");
            }
        }
        return data;
    }

    private static int lerAvaliacao() {
        int avaliacao = 0;
        while (avaliacao < 1 || avaliacao > 5) {
            try {
                avaliacao = scanner.nextInt();
                if (avaliacao < 1 || avaliacao > 5) {
                    System.out.print("Valor inválido. Avalie de 1 a 5: ");
                }
            } catch (Exception e) {
                System.out.print("Entrada inválida. Avalie de 1 a 5: ");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
        return avaliacao;
    }

    private static Quarto encontrarQuartoPorNumero(int numeroQuarto) {
        for (Quarto quarto : bancoDeDados.getQuartosDisponiveis()) {
            if (quarto.getNumero() == numeroQuarto) {
                return quarto;
            }
        }
        return null;
    }

    private static void loginAdmin() {
        System.out.print("\nLogin de Administrador\n");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (bancoDeDados.verificarCredenciais(login, senha)) {
            exibirMenuAdmin();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    private static void exibirMenuAdmin() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu Administrativo ===");
            System.out.println("1. Lançar serviço de quarto");
            System.out.println("2. Verificar serviços de quarto lançados");
            System.out.println("3. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    lancarServicoQuarto();
                    break;
                case 2:
                    verificarServicosQuarto();
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

    private static void lancarServicoQuarto() {
        System.out.println("\nLançar Serviço de Quarto");

        // Listar reservas para escolher
        List<Reserva> reservas = bancoDeDados.getReservas();
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas para lançar serviços.");
            return;
        }

        System.out.println("Reservas disponíveis:");
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            System.out.println((i + 1) + ". " + reserva.getCliente().getNome() + " - Quarto: " + reserva.getQuarto().getNumero());
        }

        System.out.print("Escolha o número da reserva: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        if (escolha < 1 || escolha > reservas.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Reserva reservaEscolhida = reservas.get(escolha - 1);

        // Solicitar informações do serviço de quarto
        System.out.print("Descrição do serviço: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor do serviço: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        // Criar e adicionar o serviço de quarto
        ServicoQuarto servico = new ServicoQuarto(descricao, valor, reservaEscolhida);
        bancoDeDados.adicionarServicoQuarto(servico);

        System.out.println("Serviço de quarto lançado com sucesso para a reserva de " + reservaEscolhida.getCliente().getNome());
    }

    private static void verificarServicosQuarto() {
        List<ServicoQuarto> servicos = bancoDeDados.getServicosQuarto();
        if (servicos.isEmpty()) {
            System.out.println("Não há serviços de quarto lançados.");
        } else {
            System.out.println("\n=== Serviços de Quarto Lançados ===");
            for (ServicoQuarto servico : servicos) {
                System.out.println("Cliente: " + servico.getReserva().getCliente().getNome());
                System.out.println("Descrição: " + servico.getDescricao());
                System.out.println("Valor: R$" + servico.getValor());
                System.out.println("-------------------------");
            }
        }
    }

}