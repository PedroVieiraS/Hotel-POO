package com.poo.hotel.poo;
import java.text.SimpleDateFormat;
import java.util.*;

public class BancoDeDados {
    private static List<Cliente> clientes;
    private static List<Quarto> quartos;
    private static List<Reserva> reservas;
    private static List<Avaliacao> avaliacoes;
    private static List<ServicoQuarto> servicosQuarto;
    private static String loginServicos;
    private static String senhaServicos;
    private static String loginGestor;
    private static String senhaGestor;
    private static Scanner scanner = new Scanner(System.in);

    public BancoDeDados() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        servicosQuarto = new ArrayList<>();
        loginServicos = "admin";
        senhaServicos = "admin123";
        loginGestor = "admin";
        senhaGestor = "admin123";
        inicializarQuartos(); // Inicializa os quartos (exemplo)
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public static List<Quarto> getQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    // Métodos para gerenciar serviços de quarto
    public static void adicionarServicoQuarto(ServicoQuarto servico) {
        servicosQuarto.add(servico);
    }

    public static List<ServicoQuarto> getServicosQuarto() {
        return servicosQuarto;
    }

    // Métodos para login de Servicos
    public static boolean verificarCredenciaisServicos(String loginServicos, String senhaServicos) {
        return loginServicos.equals(loginServicos) && senhaServicos.equals(senhaServicos);
    }

    // Métodos para login de Gestor
    public static boolean verificarCredenciaisGestor(String loginGestor, String senhaGestor) {
        return loginGestor.equals(loginGestor) && senhaGestor.equals(senhaGestor);
    }

    private void inicializarQuartos() {
        // Inicializar alguns quartos disponíveis
        quartos.add(new Quarto(101, "Luxo"));
        quartos.add(new Quarto(102, "Luxo"));
        quartos.add(new Quarto(201, "Standard"));
        quartos.add(new Quarto(202, "Standard"));
    }

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public static Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static List<Reserva> getReservasCliente(Cliente cliente) {
        return cliente.getReservas();
    }

    public List<Avaliacao> getAvaliacoesCliente(Cliente cliente) {
        return cliente.getAvaliacoes();
    }

    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public static void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public static List<Reserva> getReservas() {
        return reservas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public static void verificarServicosQuarto() {
        List<ServicoQuarto> servicos = getServicosQuarto();
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

    public static void lancarServicoQuarto() {
        System.out.println("\nLançar Serviço de Quarto");

        // Listar reservas para escolher
        List<Reserva> reservas = getReservas();
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
        adicionarServicoQuarto(servico);

        System.out.println("Serviço de quarto lançado com sucesso para a reserva de " + reservaEscolhida.getCliente().getNome());
    }

    public static Quarto encontrarQuartoPorNumero(int numeroQuarto) {
        for (Quarto quarto : getQuartosDisponiveis()) {
            if (quarto.getNumero() == numeroQuarto) {
                return quarto;
            }
        }
        return null;
    }

    public static int lerAvaliacao() {
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

    public static Date lerData() {
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

    public static boolean validarCpf(String cpf) {
        // Implementar validação de CPF
        // Exemplo simplificado: verificar se o CPF possui 11 dígitos
        return cpf.matches("\\d{11}");
    }

    public static void verAvaliacoesCliente() {
        System.out.println("\n=== Suas Avaliações ===");
        List<Avaliacao> avaliacoesCliente = PooApplication.clienteLogado.getAvaliacoes();
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

    public static void verReservasCliente() {
        System.out.println("\n=== Suas Reservas ===");
        List<Reserva> reservasCliente = getReservasCliente(PooApplication.clienteLogado);
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

    public static void loginCliente() {
        System.out.print("\nDigite seu CPF para login: ");
        String cpf = scanner.nextLine();

        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            PooApplication.clienteLogado = cliente;
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Verifique o CPF digitado.");
        }
    }

    public static void avaliarHospedagem() {
        System.out.print("\nDigite seu CPF para avaliar a hospedagem: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Avaliação não pode ser registrada.");
            return;
        }
    
        System.out.println("\n=== Avaliar Hospedagem ===");
    
        System.out.print("Avalie a qualidade da cama (de 1 a 5): ");
        int qualidadeCama = BancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a qualidade do banheiro (de 1 a 5): ");
        int qualidadeBanheiro = BancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a limpeza (de 1 a 5): ");
        int limpeza = BancoDeDados.lerAvaliacao();
    
        System.out.print("Avalie a localização (de 1 a 5): ");
        int localizacao = BancoDeDados.lerAvaliacao();
    
        Avaliacao avaliacao = new Avaliacao(0, qualidadeCama, qualidadeBanheiro, limpeza, localizacao); // Apenas a hospedagem é avaliada
        adicionarAvaliacao(avaliacao);
        cliente.adicionarAvaliacao(avaliacao); // Adicionar avaliação ao cliente
    
        System.out.println("Avaliação da hospedagem realizada com sucesso!");
    }

    public static void avaliarAtendimento() {
        System.out.print("\nDigite seu CPF para avaliar o atendimento: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = BancoDeDados.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Avaliação não pode ser registrada.");
            return;
        }
    
        System.out.println("\n=== Avaliar Atendimento ===");
    
        System.out.print("Avalie o atendimento (de 1 a 5): ");
        int atendimento = BancoDeDados.lerAvaliacao();
    
        Avaliacao avaliacao = new Avaliacao(atendimento, 0, 0, 0, 0); // Apenas o atendimento é avaliado
        BancoDeDados.adicionarAvaliacao(avaliacao);
        cliente.adicionarAvaliacao(avaliacao); // Adicionar avaliação ao cliente
    
        System.out.println("Avaliação do atendimento realizada com sucesso!");
    }

    public static void realizarReserva() {
        System.out.print("\nDigite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        if (!BancoDeDados.validarCpf(cpf)) {
            System.out.println("CPF inválido. Reserva não pode ser realizada.");
            return;
        }

        Cliente cliente = BancoDeDados.buscarClientePorCpf(cpf);
        if (cliente == null) {
            cliente = new Cliente(nome, cpf);
            adicionarCliente(cliente);
        }

        // Mostrar os tipos de quartos disponíveis
        List<Quarto> quartosDisponiveis = getQuartosDisponiveis();
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
        adicionarReserva(reserva);
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

    public static void loginServicos() {
        System.out.print("\nLogin de Serviços\n");
        System.out.print("Login: ");
        String loginServicos = scanner.nextLine();
        System.out.print("Senha: ");
        String senhaServicos = scanner.nextLine();

        if (verificarCredenciaisServicos(loginServicos, senhaServicos)) {
            PooApplication.exibirMenuServicos();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    public static void loginGestor() {
        System.out.print("\nLogin de Gestão\n");
        System.out.print("Login: ");
        String loginGestor = scanner.nextLine();
        System.out.print("Senha: ");
        String senhaGestor = scanner.nextLine();

        if (verificarCredenciaisServicos(loginGestor, senhaGestor)) {
            PooApplication.exibirMenuGestor();
        } else {
            System.out.println("Credenciais inválidas. Acesso negado.");
        }
    }

    public static void verificarFaturamento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificarFaturamento'");
    }

	public static void verificarVacancia() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'verificarVacancia'");
	}

	public static void verificarDiasMenorVacancia() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'verificarDiasMenorVacancia'");
	}

	public static void verificarIndicadoresDesempenho() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'verificarIndicadoresDesempenho'");
	}
}