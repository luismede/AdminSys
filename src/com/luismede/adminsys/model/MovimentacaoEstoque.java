package com.luismede.adminsys.model;

import java.sql.Date;

public class MovimentacaoEstoque {
    private int quantidade;
    private String tipo;
    private Date data_movimentacao;
    private String motivo;
    private Produto produto;
    private Funcionario funcionario;
}
