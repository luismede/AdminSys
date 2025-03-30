package com.luismede.adminsys.repository;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.model.Funcionario;

import java.sql.*;

public class DepartamentoRepository {
    public void addDepartamento(Departamento departamento) {
        String sql = "INSERT INTO departamento (nome, descricao, orcamento, data_criacao, ativo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, departamento.getNome());
            stmt.setString(2, departamento.getDescricao());
            stmt.setDouble(3, departamento.getOrcamento());
            stmt.setDate(4, departamento.getData_criacao());
            stmt.setInt(5, departamento.getAtivo());

            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    departamento.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
