package univille.biblioteca.DAO;

import univille.biblioteca.entidade.UsuarioComAtraso;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmprestimoDAO extends BaseDAO {

        public long qntLivrosEmprParaUsu(long idUsuario){
            String sql= "SELECT count(*) from emprestimo where id_usuario=?";
            try (Connection conn = con();
                 PreparedStatement pds = conn.prepareStatement(sql)){
                pds.setLong(1,1);
                ResultSet result = pds.executeQuery();

                if(result.next()){
                    result.getLong(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }

        public List<UsuarioComAtraso> getAllUsuComAtraso(){
            List<UsuarioComAtraso> listaAtraso = new ArrayList<>();
            String sql = """
                    SELECT U.nome,U.id_usuario,E.data_prevista_devolucao;
                    FROM USUARIO as U
                        INNER JOIN EMPRESTIMO AS E ON U.id_usuario = E.id_usuario
                    WHERE E.data_prevista_devolucao < CURRENT_DATE;
                    """;
            try(Connection conn = con();
                PreparedStatement pds = conn.prepareStatement(sql);
                ResultSet result = pds.executeQuery()){
                while(result.next()){
                    UsuarioComAtraso usuarioAtraso = new UsuarioComAtraso();
                    usuarioAtraso.setId(result.getLong("id_usuario"));
                    usuarioAtraso.setNome(result.getString("Nome"));
                    usuarioAtraso.setData_prevista_devolucao(result.getDate("data_prevista_devolucao"));
                    listaAtraso.add(usuarioAtraso);
                }
            }catch (SQLException E){
                E.printStackTrace();
            }
            return listaAtraso;
        }




}


