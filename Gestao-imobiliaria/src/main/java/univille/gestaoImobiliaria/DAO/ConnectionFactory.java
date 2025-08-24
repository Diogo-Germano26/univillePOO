package univille.gestaoImobiliaria.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    // Instância única da fábrica de conexões
    private static ConnectionFactory instance;
    // Propriedades para armazenar dados de conexão
    private Properties pro;
    // Construtor privado para evitar instanciamento externo
    private ConnectionFactory(){
        pro = new Properties();
        try(FileInputStream file = new FileInputStream("db.properties") ){
            // Carrega as configurações de conexão a partir do arquivo properties
            pro.load(file);

        }catch (IOException e){
            throw new RuntimeException("Erro ao carregar o arquivo");
        }
    }

    // Retorna a instância única da ConnectionFactory
    public static ConnectionFactory getInstance(){
        if(instance==null)instance  = new ConnectionFactory();
        return instance;
    }

    // Retorna uma nova conexão com o banco de dados usando as propriedades carregadas
    public Connection get() throws SQLException{
        String url= pro.getProperty("db.url");
        String user=pro.getProperty("db.user");
        String password=pro.getProperty("db.password");
        return DriverManager.getConnection(url,user,password);
    }

}
