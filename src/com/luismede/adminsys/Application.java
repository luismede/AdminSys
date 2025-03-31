package com.luismede.adminsys;

import com.luismede.adminsys.model.Departamento;
import com.luismede.adminsys.model.Funcionario;
import com.luismede.adminsys.repository.DepartamentoRepository;
import com.luismede.adminsys.repository.FuncionarioRepository;
import com.luismede.adminsys.service.DepartamentoService;
import com.luismede.adminsys.util.ValidadorUtil;

import java.sql.Date;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {

        DepartamentoService deps = new DepartamentoService();

          deps.alterarNome(5, "Tecnologia da Informação");


    }
}
