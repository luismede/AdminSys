package com.luismede.adminsys.test;

import com.luismede.adminsys.util.ValidadorUtil;

public class ValidadorTest {
    public static void main(String[] args) {
        ValidadorUtil validador = new ValidadorUtil();
        System.out.println(validador.isCpfValido("529.982.247-25")); // -> True (CPF Válido e com máscara)
        System.out.println(validador.isCpfValido("11111111111"));
        System.out.println(validador.isCpfValido("25325375987"));
        System.out.println(validador.isCpfValido("52998224725")); // -> True (CPF Válido e sem máscara)

        // Departamento Ativo - Valor do Banco de dados
        int statusDepartamento = 2;
        String tipo_movimentacao = "ENTRADA".toUpperCase();

        if (validador.isStatusValido(statusDepartamento)) {
            System.out.println("Status válido");
        }

        // Verifica se está ativo

        try {
            boolean ativo = validador.isAtivo(statusDepartamento);
            System.out.println("Situação: " + (ativo ? "Ativo" : "Inativo"));
            // Tratamento de erros
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        if (validador.isTipoValido(tipo_movimentacao)) {
            System.out.println("Tipo válido");
        }

    }
}
