package com.poo.hotel.poo;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private List<Cliente> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private List<Avaliacao> avaliacoes;

    public BancoDeDados() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
        avaliacoes = new ArrayList<>();

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

    public List<Quarto> getQuartosDisponiveis() {
        List<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (!quarto.isOcupado()) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
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
}