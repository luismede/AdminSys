package com.luismede.adminsys.model;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private String codigo_barras;
    private double preco_custo;
    private double preco_venda;
    private String categoria;

    // NoArgsConstructor
    public Produto() {
    }

    // AllArgsConstructor
    public Produto(Long id, String nome, String descricao, String codigo_barras, double preco_custo, double preco_venda, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.codigo_barras = codigo_barras;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.categoria = categoria;
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

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("""
                        Produto [
                            Nome: %s
                            Descrição: %s
                            Código de Barras: %s
                            Preço de Custo: R$ %.2f
                            Preço de Venda: R$ %.2f
                            Categoria: %s
                        ]
                        """,
                this.nome != null ? this.nome : "Não informado",
                this.descricao != null ? this.descricao : "Não informada",
                this.codigo_barras != null ? this.codigo_barras : "Não informado",
                this.preco_custo,
                this.preco_venda,
                this.categoria != null ? this.categoria : "Não informada"
        );
    }

}
