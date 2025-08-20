package univille.biblioteca.entidade;

public class Livro {
    private long id_livro;
    private String titulo;

    public Livro(){}
   public Livro(long id_livro,String titulo){
       this.id_livro=id_livro;
       this.titulo=titulo;
   }

    public String getTitulo(){
       return titulo;
    }

    public void setId_livro(long id_livro) {
        this.id_livro = id_livro;
    }
}
