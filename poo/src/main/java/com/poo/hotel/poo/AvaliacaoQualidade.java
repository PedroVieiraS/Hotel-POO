package com.poo.hotel.poo;

public class AvaliacaoQualidade {

    private int quarto;
    private int banheiro;
    private int limpeza;
    private int localidade;
    private int cafe;
    private int atendimento;
    
    public AvaliacaoQualidade(int quarto, int banheiro, int limpeza, int localidade, int cafe, int atendimento) {
        this.quarto = quarto;
        this.banheiro = banheiro;
        this.limpeza = limpeza;
        this.localidade = localidade;
        this.cafe = cafe;
        this.atendimento = atendimento;
    }
    
    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(int banheiro) {
        this.banheiro = banheiro;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
        this.limpeza = limpeza;
    }

    public int getLocalidade() {
        return localidade;
    }

    public void setLocalidade(int localidade) {
        this.localidade = localidade;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(int atendimento) {
        this.atendimento = atendimento;
    }


}
