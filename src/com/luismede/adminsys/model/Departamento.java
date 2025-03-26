package com.luismede.adminsys.model;

import java.sql.Date;

public class Departamento {
    private String nome;
    private String descricao;
    private double orcamento;
    private Date data_criacao;

    public Departamento() {}

    public Departamento(String nome, String descricao, double orcamento, Date data_criacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.data_criacao = data_criacao;
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

}