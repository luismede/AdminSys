package dev.adminsys.cadastros.model;

import java.sql.Date;

public class Estoque {
    private Long produto_id;
    private int quantidade;
    private int quantidade_minima;
    private String localizacao;
    private Produto produto;
    private String codigoBarras_produto;
    private String nomeProduto;
    private Date movimentacao_estoque;

    // NoArgsConstructor
    public Estoque() {}

    // AllArgsConstructor
    public Estoque(Long produto_id, int quantidade, int quantidade_minima, String localizacao, Produto produto, String codigoBarras_produto, String nomeProduto, Date movimentacao_estoque) {
        this.produto_id = produto_id;
        this.quantidade = quantidade;
        this.quantidade_minima = quantidade_minima;
        this.localizacao = localizacao;
        this.produto = produto;
        this.codigoBarras_produto = codigoBarras_produto;
        this.nomeProduto = nomeProduto;
        this.movimentacao_estoque = movimentacao_estoque;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
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

    public Date getMovimentacao_estoque() {
        return movimentacao_estoque;
    }

    public void setMovimentacao_estoque(Date movimentacao_estoque) {
        this.movimentacao_estoque = movimentacao_estoque;
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
            Movimentação do Estoque: %s
        ]
        """, quantidade, quantidade_minima,
                localizacao != null ? localizacao : "Não informada",
                nomeProduto != null ? nomeProduto : "Não vinculado",
                codigoBarras_produto != null ? codigoBarras_produto : "Não vinculado",
                movimentacao_estoque.toString());
    }

}
