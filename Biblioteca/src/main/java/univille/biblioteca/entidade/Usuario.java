package univille.biblioteca.entidade;

public class Usuario {
    private long id_usuario;
    private String nome;
    private String email;

    public Usuario(){}

    public Usuario(long id_usuario, String nome, String email){
        this.id_usuario = id_usuario;
        this.nome= nome;
        this.email = email;
    }
    public long getId_usuario(){
        return  id_usuario;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }

    public void setId_usuario(long id_usuario){
        this.id_usuario=id_usuario;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setEmail(String email){
        this.email=email;

    }


}
