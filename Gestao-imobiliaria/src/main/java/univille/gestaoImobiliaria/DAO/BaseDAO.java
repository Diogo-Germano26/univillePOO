package univille.gestaoImobiliaria.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {

    // Metodo protegido que retorna uma conexão com o banco de dados
    protected Connection con() throws SQLException{
        // Obtém a instância da ConnectionFactory e retorna a conexão
        return ConnectionFactory.getInstance().get();
    }
}
