package com.luismede.adminsys.service;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.repository.DepartamentoRepository;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;

public class DepartamentoService {
    private final DepartamentoRepository REPO;

    public DepartamentoService() {
        this.REPO = new DepartamentoRepository();
    }

    public void criarDepartamento(String nome, String descricao, double orcamento, Date data_criacao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do departamento é obrigatório");
        }

        Departamento departamento = new Departamento();
        departamento.setNome(nome);
        departamento.setDescricao(descricao);
        departamento.setOrcamento(orcamento);
        departamento.setData_criacao(data_criacao);
        departamento.setAtivo(1);

        REPO.criarDepartamento(departamento);
    }

    public void alterarStatus(int id, int novoStatus) {

        // Validação do Novo status
        if (!ValidadorUtil.isStatusValido(novoStatus)) {
            throw new IllegalArgumentException("Status inválido, Use 0 (Inátivo) ou 1 (Ativo)");
        }

        Departamento departamento = REPO.buscarPorId(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setAtivo(novoStatus);
        REPO.atualizarStatus(departamento);


    }

    public void alterarOrcamento(int id, double novoOrcamento) {
        Departamento departamento = REPO.buscarPorId(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setOrcamento(novoOrcamento);
        REPO.atualizarOrcamento(departamento);
    }

    public void alterarNome(int id, String novoNome) {
        Departamento departamento = REPO.buscarPorId(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setNome(novoNome);
        REPO.atualizarNome(departamento);
    }

    public void verificarDepartamentoAtivo(int id) {
        Departamento departamento = REPO.buscarPorId(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        if (ValidadorUtil.estaAtivo(departamento.getAtivo())) {
            System.out.printf("O departamento %s está ATIVO", departamento.getNome());
        } else {
            System.out.printf("O departamento %s está INATIVO", departamento.getNome());

        }
    }

}
