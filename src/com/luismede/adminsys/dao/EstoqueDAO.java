package com.luismede.adminsys.dao;

import com.luismede.adminsys.model.Estoque;
import com.luismede.adminsys.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public void save(Estoque estoque) {
        final String SQL = "INSERT INTO estoque VALUES (quantidade, quantidade_minima, localizacao, produto_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, estoque.getQuantidade());
            stmt.setInt(2, estoque.getQuantidade_minima());
            stmt.setString(3, estoque.getLocalizacao());

            if (estoque.getProduto() != null) {
                stmt.setLong(4, estoque.getProduto().getId());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }


            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o produto no Banco de dados", e);
        }
    }

    public List<Estoque> findAll() throws SQLException {
        final String SQL = "select p.nome as nome_produto, p.codigo_barras as codigo_barras, e.quantidade, e.quantidade_minima, e.localizacao " +
                "from estoque e join produto p on e.produto_id = p.id;";
        List<Estoque> estoques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estoque estoque = new Estoque();

                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setQuantidade_minima(rs.getInt("quantidade_minima"));
                estoque.setLocalizacao(rs.getString("localizacao"));
                estoque.setCodigoBarras_produto(rs.getString("codigo_barras"));
                estoque.setNomeProduto(rs.getString("nome_produto"));

                estoques.add(estoque);
            }
        }
        return estoques;

    }

    public Produto findById(int id) {
        final String SQL = "select p.nome, p.codigo_barras, e.quantidade, e.quantidade_minima, e.localizacao\n" +
                "from estoque e join produto p on e.produto_id = p.id where id = ?;";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();

                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCodigo_barras(rs.getString("codigo_barras"));
                    produto.setPreco_custo(rs.getDouble("preco_custo"));
                    produto.setPreco_venda(rs.getDouble("preco_venda"));
                    produto.setCategoria(rs.getString("categoria"));

                    return produto;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar por ID", e);
        }
        return null;
    }

    public int deleteById(int id) {
        final String SQL = "DELETE FROM produto WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Produto> findByStatus(int status) throws SQLException {
        final String SQL = "SELECT * FROM produto WHERE ativo = ?";
        List<Produto> produtos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)
        ) {

            stmt.setInt(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto();

                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCodigo_barras(rs.getString("codigo_barras"));
                    produto.setPreco_custo(rs.getDouble("preco_custo"));
                    produto.setPreco_venda(rs.getDouble("preco_venda"));
                    produto.setCategoria(rs.getString("categoria"));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public void savePriceCost(Produto produto) {
        final String SQL = "UPDATE produto SET preco_custo = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setDouble(1, produto.getPreco_custo());
            stmt.setLong(2, produto.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alteror o preço de custo", e);
        }
    }

    public void savePriceSale(Produto produto) {
        final String SQL = "UPDATE produto SET preco_venda = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setDouble(1, produto.getPreco_venda());
            stmt.setLong(2, produto.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alteror o preço de venda", e);
        }
    }

    public void saveName(Produto produto) {
        final String SQL = "UPDATE produto SET nome = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, produto.getNome());
            stmt.setLong(2, produto.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o nome", e);
        }
    }

    public void saveDescription(Produto produto) {
        final String SQL = "UPDATE produto SET descricao = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, produto.getDescricao());
            stmt.setLong(2, produto.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a descrição", e);
        }
    }
}
