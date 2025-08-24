package univille.gestaoImobiliaria.ImobiliariaDL;

public class CadastroCliente {
    private long idCliente;
    private String nome;
    private String email;
    private String CPF;

    public CadastroCliente() {
    }

    public CadastroCliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}