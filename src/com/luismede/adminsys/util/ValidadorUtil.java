package com.luismede.adminsys.util;

public class ValidadorUtil {
    private static final int ATIVO = 1;
    private static final int INATIVO = 0;

    private static final String ENTRADA = "ENTRADA";
    private static final String SAIDA = "SAIDA";


    public static boolean isCpfValido(String cpf) {
        // Removendo caracteres não númericos

        cpf = cpf == null ? "" : cpf.replaceAll("[^0-9]", "");

        // Verificando se o cpf está nulo ou vázio

        if (cpf.length() != 11 || cpf.matches("([0-9])\\1{10}")) {
            return false;
        }


//        Calculando o primeiro digito do verificador

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calculando o segundo digito do verificador

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos calculados conferem com os informados
        return (Character.getNumericValue(cpf.charAt(9)) == digito1) &&
                (Character.getNumericValue(cpf.charAt(10)) == digito2);
    }


    // Verifica se o status é válido (0 ou 1)
    public static boolean isStatusValido(int status) {
        return status == ATIVO || status == INATIVO;
    }

    // Verifica se o status está ativo (1)
    public static boolean isAtivo(int status) {
        if (!isStatusValido(status)) {
            throw new IllegalArgumentException("Status inválido. Use " + INATIVO + " (inativo) ou " + ATIVO + " (ativo)");
        }
        return status == ATIVO;
    }

    public static boolean estaAtivo(int status) {
        return isStatusValido(status) && status == ATIVO;
    }
    public boolean isTipoValido(String tipo) {
        return tipo == ENTRADA || tipo == SAIDA;
    }

}
