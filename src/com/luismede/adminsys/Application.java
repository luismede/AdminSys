package com.luismede.adminsys;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.model.Funcionario;
import com.luismede.adminsys.repository.DepartamentoRepository;
import com.luismede.adminsys.repository.FuncionarioRepository;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;

public class Application {
    public static void main(String[] args) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();
        Funcionario funcionario = new Funcionario();
        Departamento departamento = new Departamento();

        departamento.setNome("Transporte");
        departamento.setDescricao("Departamento responsável pelo Transporte de carnes");
        departamento.setOrcamento(1200000);
        departamento.setData_criacao(Date.valueOf("2020-06-25"));
        if (ValidadorUtil.isAtivo(1)) {
            departamento.setAtivo(1);
        }

        funcionario.setNome("Mario Belute");
        funcionario.setTelefone("(11) 94334-3243");
        funcionario.setEmail("mariobel@gmail.com");
        funcionario.setData_contratacao(Date.valueOf("2024-02-01"));
        funcionario.setSalario(4400);
        funcionario.setCargo("Técnico em TI");
        String cpf = "45289204423";
        if (ValidadorUtil.isCpfValido(cpf)) {
            funcionario.setCpf(cpf);
        } else {
            System.out.println("CPF INVÁLIDO.");
        }
        funcionario.setDepartamento(departamento);

        departamentoRepository.addDepartamento(departamento);
        funcionarioRepository.addFuncionario(funcionario);

    }
}
