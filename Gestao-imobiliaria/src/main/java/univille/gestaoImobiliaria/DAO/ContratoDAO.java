package univille.gestaoImobiliaria.DAO;

import com.sun.source.tree.TryTree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContratoDAO extends BaseDAO {
    public  long getClienteComMaisContratos(long idCliente){
        String sql = """
                SELECT c.nome AS nome_cliente, COUNT(ca.id_contrato) AS quantidade_contratos
                       FROM cliente c
                       JOIN contrato_aluguel ca ON c.id_cliente = ca.id_cliente
                       WHERE ca.contrato_ativo = TRUE
                       GROUP BY c.id_cliente, c.nome
                       ORDER BY quantidade_contratos DESC
                       LIMIT 1;
                    """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()){
            if(rs.next()){
            return rs.getLong("total_clientes");
            }

        } catch (Exception e ){
            e.printStackTrace();
        }
        return 0;
    }



}
