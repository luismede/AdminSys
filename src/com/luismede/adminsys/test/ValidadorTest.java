package com.luismede.adminsys.test;

import com.luismede.adminsys.util.ValidadorUtil;

public class ValidadorTest {
    public static void main(String[] args) {
        ValidadorUtil validadorUtil = new ValidadorUtil();
        System.out.println(validadorUtil.validarCPF("12345678910"));
        System.out.println(validadorUtil.validarCPF("1234567891"));
        System.out.println(validadorUtil.validarCPF("25325375987"));
        System.out.println(validadorUtil.validarCPF("11111111111"));
    }
}
