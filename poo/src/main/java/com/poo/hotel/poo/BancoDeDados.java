package com.poo.hotel.poo;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    public static List<Quarto> quartos = new ArrayList<>();
    
    public static List<ServicoQuarto> servicosQuarto = new ArrayList<>();

    // static {
    //     for (int i = 1; i <= 10; i++) {
    //         quartos.add(new Quarto(i, null, true));
    //     }
    // }

    public static void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

   

    public static void adicionarServicoQuarto(ServicoQuarto servicoQuarto) {
        servicosQuarto.add(servicoQuarto);
    }

    public static List<Quarto> getQuartos() {
        return quartos;
    }

    

    public static List<ServicoQuarto> getServicosQuarto() {
        return servicosQuarto;
    }
}

