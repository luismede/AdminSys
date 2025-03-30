package com.luismede.adminsys.model;

import java.sql.Date;

public class MovimentacaoEstoque {
    private int quantidade;
    private String tipo;
    private Date data_movimentacao;
    private String motivo;
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
        return "MovimentacaoEstoque {" +
                "Quantidade: " + this.quantidade +
                ", Tipo: '" + this.tipo + '\'' +
                ", Data Movimentacao:" + this.data_movimentacao +
                ", Motivo: '" + this.motivo + '\'' +
                ", Produto: " + this.produto +
                ", Funcionario: " + this.funcionario +
                '}';
    }
}
