package com.poo.hotel.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Quarto {
    private int numero;
    private Cliente cliente;
    private boolean disponivel;
    private boolean estaLimpo;
    private LocalDateTime tempoEntrada;

    public Quarto(int numero, Cliente cliente, boolean estaLimpo) {
        this.numero = numero;
        this.cliente = cliente;
        this.disponivel = true;
        this.estaLimpo = estaLimpo;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Métodos
    public void reservar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNomeCliente() {
        return cliente != null ? cliente.getNome() : "Nenhum cliente";
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.tempoEntrada = LocalDateTime.now();
        this.disponivel = false;
        verificarLimpeza();
    }

    public boolean isEstaLimpo() {
        return estaLimpo;
    }
    
    public void setEstaLimpo(boolean estaLimpo) {
        this.estaLimpo = estaLimpo;
    }

    private void verificarLimpeza() {
        Runnable tarefaLimpeza = () -> {
            long tempoDecorrido = ChronoUnit.SECONDS.between(tempoEntrada, LocalDateTime.now());
            if (tempoDecorrido > 20) {
                setEstaLimpo(false);
                System.out.println("O quarto " + numero + " está sujo.");
            }
        };
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(tarefaLimpeza, 20, TimeUnit.SECONDS);
        scheduler.shutdown();
    }

}
