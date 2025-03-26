package com.luismede.adminsys;

import com.luismede.adminsys.repository.ConnectionDB;
import com.luismede.adminsys.util.GeradorCodigo;

public class Application {
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();
        GeradorCodigo geradorCodigo = new GeradorCodigo();
        System.out.println();

        connectionDB.getConnection();

    }
}
