package dev.adminsys.cadastros.dao;

import dev.adminsys.cadastros.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    // Query para criação do funcionario na tabela
    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, telefone, email, data_contratacao, salario, cargo, cpf, dept_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getTelefone());
            stmt.setString(3, funcionario.getEmail());
            stmt.setDate(4, funcionario.getData_contratacao());
            stmt.setDouble(5, funcionario.getSalario());
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getCpf());

            if (funcionario.getDepartamento() != null) {
                stmt.setLong(8, funcionario.getDepartamento().getId());
            } else {
                stmt.setNull(8, Types.INTEGER);
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Query para buscar por todos os funcionarios
    public List<Funcionario> findAll() throws SQLException {
        final String SQL = "SELECT f.id, f.nome AS nome_funcionario, f.telefone, f.email, f.data_contratacao, f.salario, f.cargo, f.cpf, d.nome AS nome_departamento FROM funcionario f JOIN departamento d ON f.dept_id=d.id";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getLong("id"));
                funcionario.setNome(rs.getString("nome_funcionario"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setCpf(rs.getString("cpf"));

                funcionario.setNomeDepartamento(rs.getString("nome_departamento")); // Pega o nome do departamento
//                funcionario.setDepartamento(departamento); // Associa ao funcionário


                funcionarios.add(funcionario);
            }
        }
        return funcionarios;

    }

    // Query para buscar o funcionario pelo seu id
    public Funcionario findById(Long id) {
        final String SQL = "SELECT f.id, f.nome AS nome_funcionario, f.telefone, f.email, f.data_contratacao, f.salario, f.cargo, f.cpf, d.nome " +
                "AS nome_departamento FROM funcionario f JOIN departamento d ON f.dept_id=d.id WHERE f.id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();

                    funcionario.setId(rs.getLong("id"));

                    funcionario.setNome(rs.getString("nome_funcionario"));
                    funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                    funcionario.setSalario(rs.getDouble("salario"));
                    funcionario.setCargo(rs.getString("cargo"));
                    funcionario.setCpf(rs.getString("cpf"));

                    funcionario.setNomeDepartamento(rs.getString("nome_departamento")); // Pega o nome do departamento

                    return funcionario;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar por ID", e);
        }
        return null;
    }

    // Query para deletar o funcionario da tabela pelo seu id
    public int deleteById(int id) {
        final String SQL = "DELETE FROM funcionario WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            // É o mesmo que dizer: “exceção, se imprime aí!”. Ele vai imprimir não só a mensagem de erro, mas
            // toda a pilha de chamadas (Stack) até ali.
            e.printStackTrace();
        }
        return 0;
    }

    // Query para atualizar o salario do funcionario
    public void saveSalary(Funcionario funcionario) {
        final String SQL = "UPDATE funcionario SET salario = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setDouble(1, funcionario.getSalario());
            stmt.setLong(2, funcionario.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o salário", e);
        }
    }

    // Query para atualizar o e-mail do funcionario cadastrado
    public void saveEmail(Funcionario funcionario) {
        final String SQL = "UPDATE funcionario SET email = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, funcionario.getEmail());
            stmt.setLong(2, funcionario.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o e-mail", e);
        }
    }

    // Query para atualizar o telefone do funcionario cadastrado
    public void saveTelephone(Funcionario funcionario) {
        final String SQL = "UPDATE funcionario SET telefone = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, funcionario.getTelefone());
            stmt.setLong(2, funcionario.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o telefone", e);
        }
    }

    // Query para atualizar o cargo do funcionario
    public void saveRole(Funcionario funcionario) {
        final String SQL = "UPDATE funcionario SET cargo = ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, funcionario.getCargo());
            stmt.setLong(2, funcionario.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o Cargo", e);
        }
    }

}
