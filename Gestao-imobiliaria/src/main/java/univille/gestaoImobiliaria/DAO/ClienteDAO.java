package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.CadastroCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends BaseDAO{

    public void cadastrarCliente(CadastroCliente cliente){
        String sql = """
                INSERT INTO cliente (nome,email,CPF) values (?,?,?);
                """;
        try(Connection conn = con();
            PreparedStatement pds = conn.prepareStatement(sql)){

            pds.setString(1, cliente.getNome());
            pds.setString(2, cliente.getEmail());
            pds.setInt(3,cliente.getCPF());
            pds.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
        public void listarClientes() {
            String sql = "SELECT id_cliente, nome, email FROM cliente";
            try (Connection conn = con();
                 PreparedStatement pds = conn.prepareStatement(sql);
                 ResultSet rs = pds.executeQuery()) {

                System.out.println("Clientes disponíveis:");
                while (rs.next()) {
                    System.out.printf("[%d] %s (%s)%n",
                            rs.getLong("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("email"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
