package com.poo.hotel.poo;

public class ServicoQuarto {
    private String descricao;
    private boolean realizado;
    private double custo;  // Adicionando o custo do serviço

    public ServicoQuarto(String descricao, double custo) {
        this.descricao = descricao;
        this.custo = custo;
        this.realizado = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getCusto() {
        return custo;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void realizar() {
        this.realizado = true;
        // Aqui você pode optar por atualizar o faturamento do hotel quando o serviço é realizado
    }
}
