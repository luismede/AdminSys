package com.luismede.adminsys.model;

import java.sql.Date;

public class Departamento {
    private int id;
    private String nome;
    private String descricao;
    private double orcamento;
    private Date data_criacao;
    private int ativo;

    public Departamento() {
    }

    public Departamento(String nome, String descricao, double orcamento, Date data_criacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.data_criacao = data_criacao;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
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

    public double getOrcamento() {
        return orcamento;
    }


    public Date getData_criacao() {
        return data_criacao;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nome: " + this.nome + ", Descrição: " + this.descricao + ", Orçamento: " +
                this.orcamento + ", Data de Criação: " + this.data_criacao + ", Ativo: " + this.ativo;
    }

}