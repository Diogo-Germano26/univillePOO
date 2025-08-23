package univille.gestaoImobiliaria.DAO;

import com.sun.source.tree.TryTree;
import univille.gestaoImobiliaria.ImobiliariaDL.ContratoAluguel;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class ContratoDAO extends BaseDAO {
    public long getClienteComMaisContratos(long idCliente){
        String sql = """
                SELECT c.id_cliente,c.nome, COUNT(*) AS quantidade_contratos
                       FROM contrato_aluguel ca
                       join cliente c ON ca.id_cliente
                       group by ca.id_cliene,c.nome 
                       order by total_contratos desc;
                """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()){
            System.out.println("Clientes com mais contratos: ");
            while(rs.next()){
                long id= rs.getLong("id_cliente");
                String nome=rs.getString("nome");
                int totalContratos = rs.getInt("quantidade_contratos");
                System.out.printf("[%d] | %s - %d contrato(s)%n",id,nome,totalContratos);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        return 0;

    }
    public void cadastrarContrato(ContratoAluguel contrato){
        String sql = """
                INSERT INTO contrato_aluguel (valor, data_inicio, data_fim, contrato_ativo, id_imovel, id_cliente)
                values(?,?,?,?,?,?);
                """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)){
             pds.setBigDecimal(1,contrato.getValorAluguel());
             pds.setDate(2, Date.valueOf(contrato.getDataInicio()));
             pds.setDate(3,Date.valueOf(contrato.getDataFim()));
             pds.setBoolean(4,contrato.isContrato_ativo());
             pds.setLong(5,contrato.getId_imovel().getIdImovel());
             pds.setLong(6, contrato.getId_cliente().getIdCliente());

             pds.executeUpdate();

            System.out.println("Contrato cadastrado com sucesso!");
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void contratosAtivos(ContratoAluguel contrato){
        String sql = """
                select ca.id_contrato,ca.valor,ca.data_inicio,ca.data_fim,
                c.nome as cliente, i.endereco as imovel
                from contrato_aluguel ca
                join cliente c on ca.id_cliente = c.id_cliente
                join imovel i on ca.id_imovel = i.id_imovel
                where ca.contrato_ativo = true;
                order by ca.data_inicio;
                """;
        try(Connection conn = con();
        PreparedStatement pds = con().prepareStatement(sql);
        ResultSet rs = pds.executeQuery()){
            while(rs.next()){
                System.out.println("Clintes com contratos ativos:");
                long id= rs.getLong("id_contrato");
                String nome = rs.getString("cliente");
                String imovel =rs.getString("imovel");
                String endereco = rs.getString("endereco");
                BigDecimal valor=rs.getBigDecimal("valor");
                Date inicio = rs.getDate("data_inicio");
                Date fim = rs.getDate("data_fim");

                System.out.printf("[%d] | s% alugou um(a) %s em %s pelo valor de: R$%.2f de  %s até %s%n",id,nome,imovel,endereco,valor,inicio.toLocalDate(),fim.toLocalDate());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void contratosExpirandoEm30Dias() {
        String sql = """
        SELECT ca.id_contrato, ca.valor, ca.data_fim,
               c.nome AS cliente, i.endereco AS imovel
        FROM contrato_aluguel ca
        JOIN cliente c ON ca.id_cliente = c.id_cliente
        JOIN imovel i ON ca.id_imovel = i.id_imovel
        WHERE ca.contrato_ativo = true
          AND ca.data_fim BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)
        ORDER BY ca.data_fim;
    """;

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()) {

            System.out.println("Contratos expirando nos próximos 30 dias:");
            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                long idContrato = rs.getLong("id_contrato");
                BigDecimal valor = rs.getBigDecimal("valor");
                Date dataFim = rs.getDate("data_fim");
                String cliente = rs.getString("cliente");
                String imovel = rs.getString("imovel");

                System.out.printf(" [%d] %s - %s | R$%.2f | Vence em: %s%n",
                        idContrato, cliente, imovel, valor, dataFim.toLocalDate());
            }

            if (!encontrou) {
                System.out.println("Nenhum contrato expirando nos próximos 30 dias.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
