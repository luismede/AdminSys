package com.luismede.adminsys.service;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.dao.DepartamentoDAO;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;

public class DepartamentoService {
    private final DepartamentoDAO DAO;

    public DepartamentoService() {
        this.DAO = new DepartamentoDAO();
    }

    public void saveDepartamento(String nome, String descricao, double orcamento, Date data_criacao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do departamento é obrigatório");
        }

        Departamento departamento = new Departamento();
        departamento.setNome(nome);
        departamento.setDescricao(descricao);
        departamento.setOrcamento(orcamento);
        departamento.setData_criacao(data_criacao);
        departamento.setAtivo(1);

        DAO.save(departamento);
    }

    public void changeStatus(int id, int novoStatus) {

        // Validação do Novo status
        if (!ValidadorUtil.isStatusValido(novoStatus)) {
            throw new IllegalArgumentException("Status inválido, Use 0 (Inátivo) ou 1 (Ativo)");
        }

        Departamento departamento = DAO.findById(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setAtivo(novoStatus);
        DAO.saveStatus(departamento);


    }

    public void updateOrcamento(int id, double novoOrcamento) {
        Departamento departamento = DAO.findById(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setOrcamento(novoOrcamento);
        DAO.saveBudget(departamento);
    }

    public void updateNome(int id, String novoNome) {
        Departamento departamento = DAO.findById(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setNome(novoNome);
        DAO.saveName(departamento);
    }

    public void updateDescricao(int id, String novaDescricao) {
        Departamento departamento = DAO.findById(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado");
        }

        departamento.setDescricao(novaDescricao);
        DAO.saveDescription(departamento);
    }

    public boolean isDepartamentoAtivo(int id) {
        Departamento departamento = DAO.findById(id);

        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não encontrado...");
        }

        if (ValidadorUtil.estaAtivo(departamento.getAtivo())) {
            return true;
        } return false;
    }

}
