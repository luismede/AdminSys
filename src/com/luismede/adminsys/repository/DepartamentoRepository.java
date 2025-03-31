package com.luismede.adminsys.repository;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepository {

    public void criarDepartamento(Departamento departamento) {
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
            throw new RuntimeException("Erro ao criarDepartamento o departamento no Banco de dados", e);
        }
    }

    public List<Departamento> buscarTodos() throws SQLException {
        final String SQL = "SELECT * FROM departamento";
        List<Departamento> departamentos = new ArrayList<>();

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNome(rs.getString("nome"));
                departamento.setDescricao(rs.getString("descricao"));
                departamento.setOrcamento(rs.getDouble("orcamento"));
                departamento.setData_criacao(rs.getDate("data_criacao"));
                departamento.setAtivo(rs.getInt("ativo"));
                departamentos.add(departamento);
            }
        }
        return departamentos;

    }

    public Departamento buscarPorId(int id) {
        final String SQL = "SELECT * FROM departamento WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Departamento departamento = new Departamento();
                    departamento.setId(rs.getInt("id"));
                    departamento.setNome(rs.getString("nome"));
                    departamento.setDescricao(rs.getString("descricao"));
                    departamento.setOrcamento(rs.getDouble("orcamento"));
                    departamento.setData_criacao(Date.valueOf(rs.getDate("data_criacao").toLocalDate()));
                    departamento.setAtivo(rs.getInt("ativo"));
                    return departamento;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscarTodos por ID", e);
        }
        return null;
    }

    public List<Departamento> buscarPorStatus(int status) throws SQLException {
        final String SQL = "SELECT * FROM departamento WHERE ativo = ?";
        List<Departamento> departamentos = new ArrayList<>();

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)
        ) {

            stmt.setInt(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Departamento departamento = new Departamento();
                    departamento.setId(rs.getInt("id"));
                    departamento.setNome(rs.getString("nome"));
                    departamento.setDescricao(rs.getString("descricao"));
                    departamento.setOrcamento(rs.getDouble("orcamento"));
                    departamento.setData_criacao(rs.getDate("data_criacao"));
                    departamento.setAtivo(rs.getInt("ativo"));
                    departamentos.add(departamento);
                }
            }
        }
        return departamentos;
    }

    public void atualizarStatus(Departamento departamento) {
        final String SQL = "UPDATE departamento SET ativo = ? WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setInt(1, departamento.getAtivo());
            stmt.setInt(2, departamento.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizarStatus o ID", e);
        }
    }

    public void atualizarOrcamento(Departamento departamento) {
        final String SQL = "UPDATE departamento SET orcamento = ? WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setDouble(1, departamento.getOrcamento());
            stmt.setInt(2, departamento.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o orçamento", e);
        }
    }

    public void atualizarNome(Departamento departamento) {
        final String SQL = "UPDATE departamento SET nome = ? WHERE id = ?";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, departamento.getNome());
            stmt.setInt(2, departamento.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o nome", e);
        }
    }
}
