package com.luismede.adminsys.service;

import com.luismede.adminsys.util.ValidadorUtil;

public class DepartamentoService {
    ValidadorUtil validadorUtil = new ValidadorUtil();

    public void atualizarStatus(int novoStatus) {

        // Validação do Novo status

        if (!validadorUtil.isAtivo(novoStatus)) {
            throw new IllegalArgumentException("Status inválido");
        }
    }

    public void verificarDepartamentoAtivo(int status) {
        if (validadorUtil.isAtivo(status)) {
            System.out.println("Departamento ATIVO");
        } else {
            System.out.println("Departamento INATIVO");
        }
    }

}
