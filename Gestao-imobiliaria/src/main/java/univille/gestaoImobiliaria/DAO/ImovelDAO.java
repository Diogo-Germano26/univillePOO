package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.CadastroImovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDAO extends BaseDAO{

    public void cadastrarImovel(CadastroImovel imovel){
        String sql = """
                insert into imovel(tipo_imovel,endereco,tamanho,classificacao,contrato_aluguel_ativo)
                values(?,?,?,?,?);
                """;
        try(Connection conn = con();
            PreparedStatement pds = conn.prepareStatement(sql)){

            pds.setString(1,imovel.getTipoImovel());
            pds.setString(2,imovel.getEndereco());
            pds.setDouble(3,imovel.getTamanho());
            pds.setString(4,imovel.getClassificacao());
            pds.setBoolean(5,imovel.isContratoAlugelAtivo());

            pds.executeUpdate();
            System.out.println("Imóvel cadastrado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public boolean imovelExiste(String endereco) {
        String sql = "SELECT COUNT(*) FROM imovel WHERE endereco = ?";

        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setString(1, endereco);
            ResultSet rs = pds.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public void imoveisDisponiveis() {
        String sql = "SELECT id_imovel, tipo_imovel, endereco FROM imovel WHERE contrato_aluguel_ativo = false";
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql);
             ResultSet rs = pds.executeQuery()) {

            System.out.println("Imóveis disponíveis:");
            while (rs.next()) {
                System.out.printf("[%d] %s - %s%n",
                        rs.getLong("id_imovel"),
                        rs.getString("tipo_imovel"),
                        rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CadastroImovel buscarImovelPorId(long id) {
        String sql = "SELECT id_imovel, tipo_imovel, endereco, tamanho, classificacao, contrato_aluguel_ativo FROM imovel WHERE id_imovel = ?";
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setLong(1, id);
            ResultSet rs = pds.executeQuery();
            if (rs.next()) {
                CadastroImovel imovel = new CadastroImovel();
                imovel.setIdImovel(rs.getLong("id_imovel"));
                imovel.setTipoImovel(rs.getString("tipo_imovel"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setTamanho(rs.getDouble("tamanho"));
                imovel.setClassificacao(rs.getString("classificacao"));
                imovel.setContratoAlugelAtivo(rs.getBoolean("contrato_aluguel_ativo"));
                return imovel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void imovelAlugado(long idImovel) {
        String sql = "UPDATE imovel SET contrato_aluguel_ativo = true WHERE id_imovel = ?";
        try (Connection conn = con();
             PreparedStatement pds = conn.prepareStatement(sql)) {

            pds.setLong(1, idImovel);
            pds.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}