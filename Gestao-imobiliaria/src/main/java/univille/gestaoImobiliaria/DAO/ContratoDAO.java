package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.ContratoAluguel;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class ContratoDAO extends BaseDAO {
    // Método corrigido: removido o parâmetro não utilizado e corrigida a sintaxe SQL
    public void getClienteComMaisContratos(){
        String sql = """
                SELECT c.id_cliente, c.nome, COUNT(*) AS quantidade_contratos
                       FROM contrato_aluguel ca
                       JOIN cliente c ON ca.id_cliente = c.id_cliente
                       GROUP BY c.id_cliente, c.nome
                       ORDER BY quantidade_contratos DESC;
                """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()){
            System.out.println("Clientes com mais contratos: ");
            while(rs.next()){
                long id= rs.getLong("id_cliente");
                String nome=rs.getString("nome");
                int totalContratos = rs.getInt("quantidade_contratos");
                System.out.printf("[%d] | %s - %d contrato(s)%n", id, nome, totalContratos);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }

    }
    public void cadastrarContrato(ContratoAluguel contrato){
        String sql = """
                INSERT INTO contrato_aluguel (valor_aluguel, data_inicio, data_fim, contrato_ativo, id_imovel, id_cliente)
                VALUES (?, ?, ?, ?, ?, ?);
                """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pds.setBigDecimal(1, contrato.getValorAluguel());
            pds.setDate(2, Date.valueOf(contrato.getDataInicio()));
            pds.setDate(3, Date.valueOf(contrato.getDataFim()));
            pds.setBoolean(4, contrato.isContrato_ativo());
            pds.setLong(5, contrato.getId_imovel().getIdImovel());
            pds.setLong(6, contrato.getId_cliente().getIdCliente());
            pds.executeUpdate();
            System.out.println("Contrato cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void contratosAtivos(){
        String sql = """
        SELECT ca.id_contrato, ca.valor_aluguel, ca.data_fim,
               c.nome AS cliente, i.endereco AS imovel
        FROM contrato_aluguel ca
        JOIN cliente c ON ca.id_cliente = c.id_cliente
        JOIN imovel i ON ca.id_imovel = i.id_imovel
        WHERE ca.contrato_ativo = true AND ca.data_fim >= CURRENT_DATE
        ORDER BY ca.data_fim DESC;
    """;
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()) {
            System.out.println("Contratos Ativos:");
            boolean encontrou = false;
            while (rs.next()) {
                encontrou = true;
                long idContrato = rs.getLong("id_contrato");
                BigDecimal valor = rs.getBigDecimal("valor_aluguel");
                Date dataFim = rs.getDate("data_fim");
                String cliente = rs.getString("cliente");
                String imovel = rs.getString("imovel");
                System.out.printf(" [%d] %s - %s | R$%.2f | Vencimento: %s%n",
                        idContrato, cliente, imovel, valor, dataFim.toLocalDate());
            }
            if (!encontrou) {
                System.out.println("Nenhum contrato ativo encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void contratosExpirandoEm30Dias(){
        String sql = """
        SELECT ca.id_contrato, ca.valor_aluguel, ca.data_fim,
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
                BigDecimal valor = rs.getBigDecimal("valor_aluguel");
                Date dataFim = rs.getDate("data_fim");
                String cliente = rs.getString("cliente");
                String imovel = rs.getString("imovel");

                System.out.printf(" [%d] %s - %s | R$%.2f | Vence em: %s%n",
                        idContrato, cliente, imovel, valor, dataFim.toLocalDate());
            }

            if (!encontrou) {
                System.out.println("Nenhum contrato expirando encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}