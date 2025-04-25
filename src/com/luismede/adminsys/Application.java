package com.luismede.adminsys;

import com.luismede.adminsys.dao.DepartamentoDAO;
import com.luismede.adminsys.dao.EstoqueDAO;
import com.luismede.adminsys.dao.FuncionarioDAO;
import com.luismede.adminsys.dao.ProdutoDAO;
import com.luismede.adminsys.service.DepartamentoService;
import com.luismede.adminsys.service.FuncionarioService;
import com.luismede.adminsys.service.ProdutoService;
import com.luismede.adminsys.util.GeradorCodigo;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {


        ProdutoService produtoService = new ProdutoService();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();

//        System.out.println(REPODEPT.findAll());
//        System.out.println(REPOFUNC.findAll());

//        funcs.alterarSalario(3, 10000);
//        funcs.alterarEmail(3, "rodrigo@adminsys.com");

//        funcs.alterarTelefone(3, "(11) 9873-4356");
//        System.out.println(REPOFUNC.findById(3));

//        REPODEPT.deleteById(6);
//
//        REPOFUNC.deleteById(7);

//        String codigo_barras = GeradorCodigo.gerarEAN13();
//        produtoService.saveDepartamento("Salada de Frutas", "Pote de salada de frutas", codigo_barras, 12.58, 16, "Alimentos");

        System.out.println(estoqueDAO.findAll());



    }
}
