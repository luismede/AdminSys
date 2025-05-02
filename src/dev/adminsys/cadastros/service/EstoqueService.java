package dev.adminsys.cadastros.service;

import dev.adminsys.cadastros.dao.EstoqueDAO;
import dev.adminsys.cadastros.model.Estoque;
import dev.adminsys.cadastros.model.Produto;


public class EstoqueService {
    // Injeção de Dependencia
    private final EstoqueDAO DAO;

    public EstoqueService() {
        this.DAO = new EstoqueDAO();
    }

    public void save(Produto produto, int quantidade, int quantiade_minima, String localizacao) {
        if (produto == null) {
            throw new IllegalArgumentException("Assosiação do produto é obrigatório");
        }

        Estoque estoque = new Estoque();
        estoque.setQuantidade(quantidade);
        estoque.setProduto(produto);
        estoque.setQuantidade_minima(quantiade_minima);
        estoque.setLocalizacao(localizacao);

        DAO.save(estoque);
    }

    public void updateLocalizacao(int id, String localizacao) {
        Estoque estoque = DAO.findByProdutoId(id);

        if (estoque == null) {
            throw new IllegalArgumentException("Estoque do produto não encontrado.");
        }

        estoque.setLocalizacao(localizacao);
        DAO.saveLocalization(estoque);
    }
//
    public void updateQuantidade(int id, int novaQuantidade) {
        Estoque estoque = DAO.findByProdutoId(id);

        if (estoque == null) {
            throw new IllegalArgumentException("Estoque do produto não encontrado");
        }

        estoque.setQuantidade(novaQuantidade);
        DAO.saveQuantity(estoque);
    }

    public void updateQuantidadeMin(int id, int novaQuantidadeMin) {
        Estoque estoque = DAO.findByProdutoId(id);

        if (estoque == null) {
            throw new IllegalArgumentException("Estoque do produto não encontrado");
        }

        estoque.setQuantidade_minima(novaQuantidadeMin);
        DAO.saveQuantityMin(estoque);
    }
}
