package univille.biblioteca.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton + Method Factory
public class ConnectionFactory {

    // atributo global
    private static ConnectionFactory instance;

    private ConnectionFactory(){}
    // controle de criação de objetos
    public static ConnectionFactory getInstance(){
        if(instance == null) instance = new ConnectionFactory();
        return instance;
    }

    public Connection get() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "diogoGer26";
        String password = "26Diogo1024.";
        return DriverManager.getConnection(url,user,password);
    }


}