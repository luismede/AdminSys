package com.luismede.adminsys.service;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.repository.DepartamentoRepository;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;
import java.sql.SQLException;

public class DepartamentoService {
    private final DepartamentoRepository repo;

    public DepartamentoService() {
        this.repo = new DepartamentoRepository();
    }

    public void criarDepartamento(String nome, String descricao, double orcamento, Date data_criacao, int status) throws SQLException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do departamento é obrigatório");
        }

        Departamento departamento = new Departamento();
        departamento.setNome(nome);
        departamento.setDescricao(descricao);
        departamento.setOrcamento(orcamento);
        departamento.setData_criacao(data_criacao);
        departamento.setAtivo(1);

        repo.salvar(departamento);
    }

    ValidadorUtil validadorUtil = new ValidadorUtil();

    public void alterarStatus(int id, int novoStatus) throws SQLException {

        // Validação do Novo status
        if (validadorUtil.isAtivo(novoStatus)) {
            throw new IllegalArgumentException("Status inválido, Use 0 (Inátivo) ou 1 (Ativo)");
        }

        Departamento departamento = repo.buscarPorId(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setAtivo(novoStatus);
        repo.atualizar(departamento);


    }

    public void verificarDepartamentoAtivo(int status) {
        if (validadorUtil.isAtivo(status)) {
            System.out.println("Departamento ATIVO");
        } else {
            System.out.println("Departamento INATIVO");
        }
    }

}
