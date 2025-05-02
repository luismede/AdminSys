package dev.adminsys.cadastros.model;

import java.sql.Date;

public class Departamento {
    private Long id;
    private String nome;
    private String descricao;
    private double orcamento;
    private Date data_criacao;
    private int ativo;

    // NoArgsConstructor
    public Departamento() {}

    // All Args Constructor
    public Departamento(Long id, String nome, String descricao, double orcamento, Date data_criacao, int ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.data_criacao = data_criacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public Date getData_criacao() {
        return data_criacao;
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

    @Override
    public String toString() {
        return String.format("""
        Departamento [
            ID: %d
            Nome: %s
            Descrição: %s
            Orçamento: R$ %,.2f
            Data de Criação: %s
            Status: %s
        ]
        """, id, nome, descricao, orcamento,
                data_criacao != null ? data_criacao.toString() : "Não informada",
                ativo == 1 ? "Ativo" : "Inativo");
    }


}