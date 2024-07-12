package com.poo.hotel.poo;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    public static ArrayList<Quarto> quartos = new ArrayList<>();
    public static ArrayList<ServicoQuarto> servicosQuarto = new ArrayList<>();

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
