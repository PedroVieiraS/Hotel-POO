package com.poo.hotel.poo;
import java.time.LocalDate;
import java.util.ArrayList;


public class Quarto {
    private static ArrayList<Quarto> quartos = new ArrayList<Quarto>();
    
    // Atributos
    private int numero;
    private boolean estaLimpo;
    

    // Construtor
    public Quarto(int numero) {
        this.numero = numero;
        this.estaLimpo = true;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public boolean getEstaLimpo() {
        return estaLimpo;
    }

    // Setters    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEstaLimpo(boolean estaLimpo) {
        this.estaLimpo = estaLimpo;
    }

    // Getters staticos
    public static ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    // Gerador de quartos
    public static void gerarQuartos() {       
        for (int i = 0; i <= 10; i++) {
            quartos.add(new Quarto(i + 1));
        }
    }

    // Verifica disponibilidade de um quarto

    // quarto.verificarDisponibilidade(101)
    // public static boolean verificarDisponibilidade(Quarto quarto) { 
    //     
    //     for (Reserva reserva : Reserva.getReservas()) { // reservas todas 

    //         Reserva reservaMaisRecente = null;

    //         if (reserva.getQuarto().equals(quarto)) { // quarto 101 = 101
    //             if(reservaMaisRecente == null || reserva.getCheckIn().isAfter(reservaMaisRecente.getCheckIn())){
    //                 reservaMaisRecente = reserva;
    //             }
    //         }

    //         if(reservaMaisRecente != null && reservaMaisrecente.getCheckOut()){
    //             return false;
    //         }
                
    //         //     if(reserva.getCheckOut() == null && reserva.getCheckIn() == null){ // 101 existe um checkout ? sim=true : nao=false
    //         //         return true; // nem entrada e nem saida
    //         //     } else if (reserva.getCheckOut() == null){
    //         //         //
    //         //     } else {
    //         //         return false;
    //         //     }
    //         // } else{
    //         //     return true;// aguarde
    //         // }
    //     }
    //     return false;
    // }
    
    public static boolean verificarDisponibilidade(Quarto quarto) { 

        // Verificar a disponibilidade dentro do Array de reservas
        // Verificar a mais recente
        // Verificar se a mais recente tem checkout em aberto
        // Se sim, o quarto está disponível
        // Se não, o quarto não está disponível
        
        Reserva reservaMaisRecente = null;
    
        for (Reserva reserva : Reserva.getReservas()) { 
            if (reserva.getQuarto().equals(quarto)) { 
                if (reservaMaisRecente == null || reserva.getCheckIn().isAfter(reservaMaisRecente.getCheckIn())) {
                    reservaMaisRecente = reserva; 
                }
            }
        }
    
        if (reservaMaisRecente != null && reservaMaisRecente.getCheckOut() == null) {
            return false; 
        }
    
        return true; 
    }
}
