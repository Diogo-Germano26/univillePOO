package univille.biblioteca.entidade;

public class UsuarioComAtraso extends Usuario{
    private long quantLivrosAtrasados;

    public UsuarioComAtraso(){

    }

    public UsuarioComAtraso(long quantLivrosAtrasados) {
        this.quantLivrosAtrasados = quantLivrosAtrasados;
    }

    public long getQuantLivrosAtrasados() {
        return quantLivrosAtrasados;
    }

    public void setQuantLivrosAtrasados(long quantLivrosAtrasados) {
        this.quantLivrosAtrasados = quantLivrosAtrasados;
    }
}

