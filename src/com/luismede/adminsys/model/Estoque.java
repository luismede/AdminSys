package com.luismede.adminsys.model;

public class Estoque {
    private int quantidade;
    private int quantidade_minima;
    private String localizacao;
    private Produto produto;

    public Estoque() {}

    public Estoque(int quantidade, int quantidade_minima, String localizacao, Produto produto) {
        this.quantidade = quantidade;
        this.quantidade_minima = quantidade_minima;
        this.localizacao = localizacao;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade_minima() {
        return quantidade_minima;
    }

    public void setQuantidade_minima(int quantidade_minima) {
        this.quantidade_minima = quantidade_minima;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Quantidade: " + this.quantidade + ", Quantidade mínima: " + this.quantidade_minima + ", Localização: " +
                this.localizacao + "Produto: " + this.produto;
    }
}
