package com.luismede.adminsys.service;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.model.Funcionario;
import com.luismede.adminsys.dao.FuncionarioDAO;

import java.sql.Date;

public class FuncionarioService {
    private static FuncionarioDAO DAO = new FuncionarioDAO();

    // Injeção de Depedendencia
    public FuncionarioService() {
        this.DAO = new FuncionarioDAO();
    }

    public void save(String nome, String telefone, String email, Date data_contratacao, double salario, String cargo, String cpf, Departamento departamento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionario é obrigatório");
        }
        if (cargo == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Cargo do funcionario é obrigatório");
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);
        funcionario.setData_contratacao(data_contratacao);
        funcionario.setSalario(salario);
        funcionario.setCargo(cargo);
        funcionario.setCpf(cpf);
        funcionario.setDepartamento(departamento);

        DAO.save(funcionario);
    }

    public void updateSalario(Long id, double novoSalario) {
        Funcionario funcionario = DAO.findById(id);

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado");
        }

        funcionario.setSalario(novoSalario);
        DAO.saveSalary(funcionario);
    }

    public void updateEmail(Long id, String novoEmail) {
        Funcionario funcionario = DAO.findById(id);

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado");
        }

        funcionario.setEmail(novoEmail);
        DAO.saveEmail(funcionario);
    }

    public void updateTelefone(Long id, String novoTelefone) {
        Funcionario funcionario = DAO.findById(id);

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado");
        }

        funcionario.setTelefone(novoTelefone);
        DAO.saveTelephone(funcionario);
    }

    public void updateCargo(Long id, String novoCargo) {
        Funcionario funcionario = DAO.findById(id);

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não encontrado.");
        }

        funcionario.setCargo(novoCargo);
        DAO.saveRole(funcionario);
    }



}
