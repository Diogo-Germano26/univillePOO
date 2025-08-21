package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.ContratoAluguel;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private Properties pro;
    private ConnectionFactory(){
        pro = new Properties();
        try(FileInputStream file = new FileInputStream("db.properties") ){
            pro.load(file);

        }catch (IOException e){
            throw new RuntimeException("Erro ao carregar o arquivo");
        }
    }

    public static ConnectionFactory getInstance(){
        if(instance==null)instance  = new ConnectionFactory();
        return instance;
    }

    public Connection get() throws SQLException{
        String url= pro.getProperty("db.url");
        String user=pro.getProperty("db.user");
        String password=pro.getProperty("db.password");
        return DriverManager.getConnection(url,user,password);
    }

}
