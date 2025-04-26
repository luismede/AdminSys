package com.luismede.adminsys;

import com.luismede.adminsys.dao.DepartamentoDAO;
import com.luismede.adminsys.dao.EstoqueDAO;
import com.luismede.adminsys.dao.FuncionarioDAO;
import com.luismede.adminsys.dao.ProdutoDAO;
import com.luismede.adminsys.model.Estoque;
import com.luismede.adminsys.model.Produto;
import com.luismede.adminsys.service.EstoqueService;
import com.luismede.adminsys.service.ProdutoService;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {


        ProdutoService produtoService = new ProdutoService();
        EstoqueService estoqueService = new EstoqueService();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();

//        System.out.println(REPODEPT.findAll());
//        System.out.println(REPOFUNC.findAll());

//        funcs.alterarSalario(3, 10000);
//        funcs.alterarEmail(3, "rodrigo@adminsys.com");

//        funcs.alterarTelefone(3, "(11) 9873-4356");
//        System.out.println(REPOFUNC.findByProdutoId(3));

//        REPODEPT.deleteById(6);
//
//        REPOFUNC.deleteById(7);

//        String codigo_barras = GeradorCodigo.gerarEAN13();
//        produtoService.saveProduto("Salada de Frutas", "Pote de salada de frutas", codigo_barras, 12.58, 16, "Alimentos");

//        System.out.println(estoqueDAO.findByProdutoId(1));
//
//        System.out.println(produtoDAO.findAll());
////        produto.setId(2);
////        produto.setId();
////        estoqueService.save(produto, 12, 5, "Departamento principal");
//        System.out.println(estoqueDAO.findAll());
//        estoqueService.updateLocalizacao(1, "Departameto principal");
//            estoqueService.updateLocalizacao(2, "Estoque central");
//        estoqueService.updateQuantidade(2, 2);
//        Estoque estoque = estoqueDAO.findByProdutoId(2);
//        System.out.println(estoque);
//        estoqueService.updateQuantidade(1, 5);
//        estoqueService.updateQuantidadeMin(1, 10);
        estoqueService.updateLocalizacao(1, "Estoque central");
    }
}
