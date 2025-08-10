package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection get() throws SQLException {
        // 1. Defina a URL do banco de dados, nome de usuário e senha para MySQL
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";

        // 2. Carregue o driver do banco de dados MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado.");
            throw new SQLException("Driver JDBC do MySQL não encontrado.", e);
        }

        // 3. Estabeleça a conexão
        return DriverManager.getConnection(url, user, password);
    }
}