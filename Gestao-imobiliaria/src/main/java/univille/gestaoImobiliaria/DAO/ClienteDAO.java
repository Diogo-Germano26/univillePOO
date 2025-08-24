package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.Entidades.CadastroCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends BaseDAO{

    // Verifica se já existe um cliente cadastrado com o CPF informado
    public boolean cpfExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE CPF = ?";

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setString(1, cpf);
            ResultSet rs = pds.executeQuery();

            // Retorna true se o CPF já estiver cadastrado
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    // Busca e retorna um cliente pelo CPF
    public CadastroCliente buscarCpf(String cpf) {
        String sql = "SELECT id_cliente, nome, email, CPF FROM cliente WHERE CPF = ?";

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setString(1, cpf);
            ResultSet rs = pds.executeQuery();

            // Cria e popula o objeto cliente se encontrado
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

        // Retorna null se nenhum cliente for encontrado
        return null;
    }

    // Busca e retorna um cliente pelo ID
    public CadastroCliente buscarClientePorId(long id) {
        String sql = "SELECT id_cliente, nome, email, CPF FROM cliente WHERE id_cliente = ?";
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setLong(1, id);
            ResultSet rs = pds.executeQuery();

            // Cria e popula o objeto cliente se encontrado
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
    // Cadastra um novo cliente no banco de dados
    public void cadastrarCliente(CadastroCliente cliente){
        // Verifica se o CPF já existe antes de cadastrar
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
    // Lista todos os clientes cadastrados
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