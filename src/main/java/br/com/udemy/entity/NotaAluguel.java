package br.com.udemy.entity;

import java.util.Date;

public class NotaAluguel {

    private int preco;
    private Date dataEntrega;
    private int pontuacao;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }

    public void setPontuacao(int i) {
        this.pontuacao = pontuacao;
    }
}
