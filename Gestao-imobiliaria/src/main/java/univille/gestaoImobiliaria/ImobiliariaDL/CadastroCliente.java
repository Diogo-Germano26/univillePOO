    package univille.gestaoImobiliaria.ImobiliariaDL;

public class CadastroCliente {
    private long idCliente;
    private String nome;
    private String email;
    private int CPF;

    public CadastroCliente() {
    }

    public CadastroCliente(long idCliente, String nome, String email, int CPF) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
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

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
}
