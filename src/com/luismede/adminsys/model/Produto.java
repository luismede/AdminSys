package com.luismede.adminsys.model;

public class Produto {
    private String nome;
    private String descricao;
    private String codigo_barras;
    private double preco_custo;
    private double preco_venda;
    private String categoria;

    public Produto() {}

    public Produto(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Produto(String nome, String descricao, String codigo_barras, double preco_custo, double preco_venda, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigo_barras = codigo_barras;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }


    public double getPreco_custo() {
        return preco_custo;
    }


    public double getPreco_venda() {
        return preco_venda;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Nome: " + this.descricao + ", Código  de Barras: " + this.codigo_barras + ", Preço de custo: " +
                this.preco_custo + ", Preço de Venda: " + this.preco_venda + ", Categoria: " + this.categoria;
    }
}
