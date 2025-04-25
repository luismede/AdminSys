package com.luismede.adminsys.service;

import com.luismede.adminsys.dao.DepartamentoDAO;
import com.luismede.adminsys.dao.ProdutoDAO;
import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.model.Produto;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;

public class ProdutoService {
    private final ProdutoDAO DAO;

    public ProdutoService() {
        this.DAO = new ProdutoDAO();
    }

    public void saveDepartamento(String nome, String descricao, String codigo_barras, double preco_custo, double preco_venda, String categoria) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        }

        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setCodigo_barras(codigo_barras);
        produto.setPreco_custo(preco_custo);
        produto.setPreco_venda(preco_venda);
        produto.setCategoria(categoria);

        DAO.save(produto);
    }

    public void updatePrecoCusto(int id, double novoPrecoCusto) {
        Produto produto = DAO.findById(id);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        produto.setPreco_custo(novoPrecoCusto);
        DAO.savePriceCost(produto);
    }

    public void updatePrecoVenda(int id, double novoPrecoVenda) {
        Produto produto = DAO.findById(id);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        produto.setPreco_custo(novoPrecoVenda);
        DAO.savePriceSale(produto);
    }

    public void updateNome(int id, String novoNome) {
        Produto produto = DAO.findById(id);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        produto.setNome(novoNome);
        DAO.saveName(produto);
    }

    public void updateDescricao(int id, String novaDescricao) {
        Produto produto = DAO.findById(id);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        produto.setDescricao(novaDescricao);
        DAO.saveDescription(produto);
    }

}
