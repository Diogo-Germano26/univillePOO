package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.CadastroCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends BaseDAO{

    public boolean cpfExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE CPF = ?";

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setString(1, cpf);
            ResultSet rs = pds.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public CadastroCliente buscarCpf(String cpf) {
        String sql = "SELECT id_cliente, nome, email, CPF FROM cliente WHERE CPF = ?";

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setString(1, cpf);
            ResultSet rs = pds.executeQuery();

            if (rs.next()) {
                CadastroCliente cliente = new CadastroCliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCPF(rs.getString("CPF"));
                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    // Novo metodo adicionado
    public CadastroCliente buscarClientePorId(long id) {
        String sql = "SELECT id_cliente, nome, email, CPF FROM cliente WHERE id_cliente = ?";
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setLong(1, id);
            ResultSet rs = pds.executeQuery();

            if (rs.next()) {
                CadastroCliente cliente = new CadastroCliente();
                cliente.setIdCliente(rs.getLong("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCPF(rs.getString("CPF"));
                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void cadastrarCliente(CadastroCliente cliente){
        if (cpfExiste(cliente.getCPF())) {
            System.out.println("⚠️ Já existe um cliente cadastrado com este CPF.");
            return;
        }

        String sql = """
                INSERT INTO cliente (nome,email,CPF) values (?,?,?);
                """;
        try(Connection conn = con();
            PreparedStatement pds = conn.prepareStatement(sql)){

            pds.setString(1, cliente.getNome());
            pds.setString(2, cliente.getEmail());
            pds.setString(3,cliente.getCPF());
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