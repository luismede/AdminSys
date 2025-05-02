package dev.adminsys.cadastros.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Classe responsável por criar conexões com o banco de dados.
 */

public class ConnectionFactory {
    // Definição das informações de conexão do DB, utilizando o arquivo .env
    private static final String HOST = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    protected Connection connection;

    public static Connection getConnection() {
        try {
            // Driver que srá utilizado pelo Driver Manager
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao se conectar ao Driver: ",e);
        }
        try {
//            Se conectando ao BD
          return DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao se conectar com o BD:", e);
        }
    }

    public void closeConnection() {
        try {
            // Validando se a conexão é diferente de nulo e que a conxão já não está fechada
            if(connection != null && !connection.isClosed()) {
                // Fechando a conexão
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o BD:",e);
        }
    }
}
