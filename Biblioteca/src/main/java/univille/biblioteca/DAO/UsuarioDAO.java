    package univille.biblioteca.DAO;

    import univille.biblioteca.entidade.Usuario;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.ExecutionException;

    public class UsuarioDAO extends BaseDAO{

        public List<Usuario> obterTodosUsuarios(){
            List<Usuario> todosUsuarios = new ArrayList<>();
            String sql= """
                    SELECT nome from USUARIO;
                    """;
            try(Connection conn = con();
                PreparedStatement pds = conn.prepareStatement(sql);
                ResultSet result = pds.executeQuery()){

                while(result.next()){
                    Usuario usuario = new Usuario();
                    usuario.setNome(result.getString("Nome"));
                    todosUsuarios.add(usuario);
                }
            }catch (SQLException E){
                E.printStackTrace();
            }
            return todosUsuarios;
        }
    }
