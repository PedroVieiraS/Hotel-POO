package com.poo.hotel.poo;

import java.util.ArrayList;

public class Cliente {
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public static void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static Cliente getClienteByCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente getClienteByNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public static int getQuantidadeClientes() {
        return clientes.size();
    }

    public static boolean clienteExiste(Cliente cliente) {
        return clientes.contains(cliente);
    }   

    public static boolean clienteExisteByCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public static boolean clienteExisteByNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static void gerarClientes() {
        Cliente.adicionarCliente(new Cliente("João", "123.456.789-00"));
        Cliente.adicionarCliente(new Cliente("Maria", "987.654.321-00"));
        Cliente.adicionarCliente(new Cliente("José", "456.789.123-00"));
        Cliente.adicionarCliente(new Cliente("Ana", "654.321.987-00"));
        Cliente.adicionarCliente(new Cliente("Pedro", "789.123.456-00"));
        Cliente.adicionarCliente(new Cliente("Paula", "321.987.654-00"));
        Cliente.adicionarCliente(new Cliente("Carlos", "123.456.789-01"));
        Cliente.adicionarCliente(new Cliente("Mariana", "987.654.321-01"));
        Cliente.adicionarCliente(new Cliente("Joaquim", "456.789.123-01"));
        Cliente.adicionarCliente(new Cliente("Amanda", "654.321.987-01"));
        Cliente.adicionarCliente(new Cliente("Pietro", "789.123.456-01"));
        Cliente.adicionarCliente(new Cliente("Paulo", "321.987.654-01"));
    }

    public void cadastrarCliente(String nome, String cpf){
        Cliente.adicionarCliente(new Cliente(this.nome, this.cpf));
    }
}
