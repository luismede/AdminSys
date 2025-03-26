package com.luismede.adminsys.util;

import java.util.Random;

public class GeradorCodigo {
    private static final String CODIGO_PAIS = "789"; // Código do Brasil
    private final Random random = new Random();

    public String gerarEAN13() {
        // 9 dígitos aleatórios (total 12 com o prefixo)

        String base = CODIGO_PAIS + String.format("%09d", random.nextInt(1_000_000_000));

        int digitoVerificador = calcularDigitoVerificadorEAN13(base);
        return base + digitoVerificador;
    }

    private static int calcularDigitoVerificadorEAN13(String codigo12Digitos) {
        // Definição de um acumulador para somar os valores processados

        int soma = 0;

        // percorrendo cada caractere da string de 12 digitos

        for (int i = 0; i < 12; i++) {

            /** Convertendo o caracter da posição <b>i</b> para seu valor <i>numerico.</i> */

            int digito = Character.getNumericValue(codigo12Digitos.charAt(i));

            /**
            * Multiplicacao alternada
            * Para posições <i>pares (0,2,4...):</i> multiplica-se por 3
             * Para posições <i>impares (1,3,5...):</i> multiplica-se por 1
            */

            soma += digito * ((i % 2 == 0) ? 1 : 3);
        }

        return (10 - (soma % 10) % 10);
    }
}
