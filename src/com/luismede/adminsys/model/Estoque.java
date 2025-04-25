package com.luismede.adminsys.model;

public class Estoque {
    private int quantidade;
    private int quantidade_minima;
    private String localizacao;
    private Produto produto;
    private String codigoBarras_produto;
    private String nomeProduto;

    public Estoque() {}

    public Estoque(int quantidade, int quantidade_minima, String localizacao, Produto produto, String codigoBarras_produto, String nomeProduto) {
        this.quantidade = quantidade;
        this.quantidade_minima = quantidade_minima;
        this.localizacao = localizacao;
        this.produto = produto;
        this.codigoBarras_produto = codigoBarras_produto;
        this.nomeProduto = nomeProduto;
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

    public String getCodigoBarras_produto() {
        return codigoBarras_produto;
    }

    public void setCodigoBarras_produto(String codigoBarras_produto) {
        this.codigoBarras_produto = codigoBarras_produto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public String toString() {
        return String.format("""
        Estoque [
            Quantidade Atual: %d
            Quantidade Mínima: %d
            Localização: %s
            Produto: %s
            Codigo de Barras: %s
        ]
        """, quantidade, quantidade_minima,
                localizacao != null ? localizacao : "Não informada",
                nomeProduto != null ? nomeProduto : "Não vinculado",
                codigoBarras_produto != null ? codigoBarras_produto : "Não vinculado");
    }

}
