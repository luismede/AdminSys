package com.luismede.adminsys.repository;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.*;

public class DepartamentoRepository {

    public void salvar(Departamento departamento) {
        final String SQL = "INSERT INTO departamento (nome, descricao, orcamento, data_criacao, ativo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getDescricao());
            stmt.setDouble(3, departamento.getOrcamento());
            stmt.setDate(4, departamento.getData_criacao());
            stmt.setBoolean(5, ValidadorUtil.isAtivo(departamento.getAtivo()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    departamento.setId(rs.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado, nenhum ID obtido.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o departamento no Banco de dados", e);
        }
    }

    public Departamento buscarPorId(int id) throws SQLException {
        final String SQL = "SELECT * FROM departamento WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    Departamento departamento = new Departamento();
                    departamento.setId(rs.getInt("id"));
                    departamento.setNome(rs.getString("nome"));
                    departamento.setDescricao(rs.getString("descricao"));
                    departamento.setOrcamento(rs.getDouble("orcamento"));
                    departamento.setData_criacao(rs.getDate("data_criacao"));
                    departamento.setAtivo(rs.getInt("ativo"));
                    return departamento;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar por ID", e);
        }

        return null;
    }

    public void atualizar(Departamento departamento) {
        final String SQL = "UPDATE departamento SET ativo = ? WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL))  {
            stmt.setInt(1, departamento.getAtivo());
            stmt.setInt(2, departamento.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o ID", e);
        }
    }
}
