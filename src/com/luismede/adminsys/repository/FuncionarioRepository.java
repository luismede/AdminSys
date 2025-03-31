package com.luismede.adminsys.repository;

import com.luismede.adminsys.model.Funcionario;

import java.sql.*;

public class FuncionarioRepository {
    public void criarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, telefone, email, data_contratacao, salario, cargo, cpf, dept_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getTelefone());
            stmt.setString(3, funcionario.getEmail());
            stmt.setDate(4, funcionario.getData_contratacao());
            stmt.setDouble(5, funcionario.getSalario());
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getCpf());

            if (funcionario.getDepartamento() != null) {
                stmt.setInt(8, funcionario.getDepartamento().getId());
            } else {
                stmt.setNull(8, Types.INTEGER);
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
