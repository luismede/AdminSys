package dev.adminsys.cadastros.dao;

import dev.adminsys.cadastros.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
        // Query para registro do produto na tabela
        public void save(Produto produto) {
            final String SQL = "INSERT INTO produto (nome, descricao, codigo_barras, preco_custo, preco_venda, categoria) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setString(3, produto.getCodigo_barras());
                stmt.setDouble(4, produto.getPreco_custo());
                stmt.setDouble(5, produto.getPreco_venda());
                stmt.setString(6, produto.getCategoria());

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        produto.setId(rs.getLong(1));
                    } else {
                        throw new SQLException("Falha ao obter o ID gerado, nenhum ID obtido.");
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao salvar o produto no Banco de dados", e);
            }
        }

        // Query para buscar por todos os produtos na tabela
        public List<Produto> findAll() throws SQLException {
            final String SQL = "SELECT * FROM produto";
            List<Produto> produtos = new ArrayList<>();

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(SQL);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getLong("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCodigo_barras(rs.getString("codigo_barras"));
                    produto.setPreco_custo(rs.getDouble("preco_custo"));
                    produto.setPreco_venda(rs.getDouble("preco_venda"));
                    produto.setCategoria(rs.getString("categoria"));

                    produtos.add(produto);
                }
            }
            return produtos;

        }

        // Query para buscar o produto pelo id
        public Produto findById(int id) {
            final String SQL = "SELECT * FROM produto WHERE id = ?";

            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(SQL)) {

                stmt.setInt(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Produto produto = new Produto();

                        produto.setId(rs.getLong("id"));
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

        // Query para deletar um produto pelo seu id
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

        // Query para buscar o produto pelo seu status
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

                        produto.setId(rs.getLong("id"));
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

        // Query para atualizar o preço de custo do produto
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

        // Query para atualizar o preço de venda do produto
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

        // Query para atualizar o nome do produto
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

        // Query para atualizar a descrição do produto
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
