package com.luismede.adminsys.model;

import java.sql.Date;

public class MovimentacaoEstoque {
    private long id;
    private int quantidade;
    private String tipo;
    private Date data_movimentacao;
    private String motivo;
    private String nomeFuncionario;
    private String nomeProduto;
    private Produto produto;
    private Funcionario funcionario;

    public MovimentacaoEstoque() {}

    public MovimentacaoEstoque(int quantidade, String tipo, Date data_movimentacao, String motivo, Produto produto, Funcionario funcionario) {
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data_movimentacao = data_movimentacao;
        this.motivo = motivo;
        this.produto = produto;
        this.funcionario = funcionario;
    }

    public MovimentacaoEstoque(int quantidade, String tipo, Date data_movimentacao, String motivo, String nomeFuncionario, String nomeProduto, Produto produto, Funcionario funcionario) {
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.data_movimentacao = data_movimentacao;
        this.motivo = motivo;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeProduto = nomeProduto;
        this.produto = produto;
        this.funcionario = funcionario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData_movimentacao() {
        return data_movimentacao;
    }

    public void setData_movimentacao(Date data_movimentacao) {
        this.data_movimentacao = data_movimentacao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return String.format("""
        Movimentação de Estoque [
            Quantidade: %d
            Tipo: %s
            Data da Movimentação: %s
            Motivo: %s
            Produto: %s
            Funcionário: %s
        ]
        """, quantidade, tipo,
                data_movimentacao != null ? data_movimentacao.toString() : "Não informada",
                motivo != null ? motivo : "Não informado",
                nomeProduto != null ? nomeProduto : "Não vinculado",
                nomeFuncionario != null ? nomeFuncionario : "Não vinculado");
    }

}
