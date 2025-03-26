package com.luismede.adminsys.util;

public class ValidadorUtil {
    public boolean validarCPF(String cpf) {
        // Removendo caracteres não númericos

        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificando o tamanho do CPF

        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os digitos são iguais

        if (cpf.matches("([0-9])\\1{10}")) {
            return false;
        }

        return false;
    }
}
