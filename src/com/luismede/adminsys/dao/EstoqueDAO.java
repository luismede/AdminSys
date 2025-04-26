package com.luismede.adminsys.dao;

import com.luismede.adminsys.model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public void save(Estoque estoque) {
        final String SQL = "INSERT INTO estoque (quantidade, quantidade_minima, localizacao, produto_id) VALUES (?, ?, ?, ?)";

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
            throw new RuntimeException("Erro ao salvar o estoque no Banco de dados", e);
        }
    }

    public List<Estoque> findAll() throws SQLException {
        final String SQL = "select e.produto_id, p.nome as nome_produto, p.codigo_barras as codigo_barras, e.quantidade, e.quantidade_minima, e.localizacao e.movimentacao_estoque" +
                "from estoque e join produto p on e.produto_id = p.id;";
        List<Estoque> estoques = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estoque estoque = new Estoque();

                estoque.setProduto_id(rs.getLong("produto_id"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setQuantidade_minima(rs.getInt("quantidade_minima"));
                estoque.setLocalizacao(rs.getString("localizacao"));
                estoque.setCodigoBarras_produto(rs.getString("codigo_barras"));
                estoque.setNomeProduto(rs.getString("nome_produto"));
                estoque.setMovimentacao_estoque(rs.getDate("movimentacao_estoque"));

                estoques.add(estoque);
            }
        }
        return estoques;

    }

    public Estoque findByProdutoId(int produtoId) {
        final String SQL = "select e.produto_id, p.nome as nome_produto, p.codigo_barras as codigo_barras, e.quantidade, e.quantidade_minima, e.localizacao, e.movimentacao_estoque\n" +
                "from estoque e join produto p on e.produto_id = p.id where e.produto_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, produtoId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estoque estoque = new Estoque();
                    estoque.setProduto_id(rs.getLong("produto_id"));
                    estoque.setNomeProduto(rs.getString("nome_produto"));
                    estoque.setCodigoBarras_produto(rs.getString("codigo_barras"));
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    estoque.setQuantidade_minima(rs.getInt("quantidade_minima"));
                    estoque.setLocalizacao(rs.getString("localizacao"));
                    estoque.setMovimentacao_estoque(rs.getDate("movimentacao_estoque"));

                    return estoque;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar por ID", e);
        }
        return null;
    }

    public int deleteById(int id) {
        final String SQL = "DELETE FROM estoque WHERE produto_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveQuantity(Estoque estoque) {
        final String SQL = "UPDATE estoque SET quantidade = ?, movimentacao_estoque = current_date WHERE produto_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setInt(1, estoque.getQuantidade());
            stmt.setLong(2, estoque.getProduto_id());
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a quantidade em estoque", e);
        }
    }

    public void saveQuantityMin(Estoque estoque) {
        final String SQL = "UPDATE estoque SET quantidade_minima = ?, movimentacao_estoque = current_date WHERE produto_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setDouble(1, estoque.getQuantidade_minima());
            stmt.setLong(2, estoque.getProduto_id());
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a quantidade minima em estoque", e);
        }
    }

    public void saveLocalization(Estoque estoque) {
        final String SQL = "UPDATE estoque SET localizacao = ?, movimentacao_estoque = current_date WHERE produto_id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, estoque.getLocalizacao());
            stmt.setLong(2, estoque.getProduto_id());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a localização", e);
        }
    }
}
