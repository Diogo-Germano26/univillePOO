package univille.gestaoImobiliaria.DAO;

import univille.gestaoImobiliaria.ImobiliariaDL.CadastroImovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDAO extends BaseDAO{

    public void cadastrarImovel(CadastroImovel imovel){
        String sql = """
                insert into imovel(tipo_imovel,endereco,tamanho,classificacao)
                values(?,?,?,?);
                """;
        try(Connection conn = con();
            PreparedStatement pds = con().prepareStatement(sql)){

            pds.setString(1,imovel.getTipoImovel());
            pds.setString(2,imovel.getEndereco());
            pds.setDouble(3,imovel.getTamanho());
            pds.setString(4,imovel.getClassificacao());

            pds.executeUpdate();
            System.out.println("Imóvel cadastrado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void imoveisDisponiveis(){
        String sql = """
                SELECT
                    tipo_imovel AS nome,
                    endereco,
                    tamanho,
                    classificacao
                FROM
                    imovel
                WHERE
                    contrato_ativo_aluguel = 0;
                """;
        try(Connection conn = con();
            PreparedStatement pds = con().prepareStatement(sql);
            ResultSet rs = pds.executeQuery()){
                while(rs.next()) {
                    String nome = rs.getString("nome");
                    String endereco = rs.getString("endereco");
                    double tamanho = rs.getDouble("tamanho");
                    String classificacao = rs.getString("classificacao");

                    System.out.println("Imóvel cadastrado com sucesso!");
                    System.out.printf("Nome: %s | Endereço: %s | Tamanho: %.2f m² | Classificação: %s%n",
                            nome, endereco, tamanho, classificacao);
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void listarImoveis() {
        String sql = "SELECT id_imovel, tipo_imovel, endereco FROM imovel";
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

}
