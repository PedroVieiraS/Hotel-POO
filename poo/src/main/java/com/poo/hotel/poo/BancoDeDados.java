package com.poo.hotel.poo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDeDados {
    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private List<Avaliacao> avaliacoes;
    private List<ServicoQuarto> servicosQuarto;
    private String loginAdmin;
    private String senhaAdmin;
    private Scanner scanner = new Scanner(System.in);

    public BancoDeDados() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        this.servicosQuarto = new ArrayList<>();
        this.loginAdmin = "admin";
        this.senhaAdmin = "admin123";
        inicializarQuartos(); // Inicializa os quartos (exemplo)
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public List<Quarto> getQuartosDisponiveis() {
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
    public void adicionarServicoQuarto(ServicoQuarto servico) {
        servicosQuarto.add(servico);
    }

    public List<ServicoQuarto> getServicosQuarto() {
        return servicosQuarto;
    }

    // Métodos para login de administrador
    public boolean verificarCredenciais(String login, String senha) {
        return login.equals(loginAdmin) && senha.equals(senhaAdmin);
    }

    private void inicializarQuartos() {
        // Inicializar alguns quartos disponíveis
        quartos.add(new Quarto(101, "Luxo"));
        quartos.add(new Quarto(102, "Luxo"));
        quartos.add(new Quarto(201, "Standard"));
        quartos.add(new Quarto(202, "Standard"));
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Reserva> getReservasCliente(Cliente cliente) {
        return cliente.getReservas();
    }

    public List<Avaliacao> getAvaliacoesCliente(Cliente cliente) {
        return cliente.getAvaliacoes();
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public int lerAvaliacao() {
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

}