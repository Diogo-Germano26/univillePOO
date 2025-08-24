package univille.gestaoImobiliaria.Entidades;

public class CadastroCliente {
    private long idCliente;
    private String nome;
    private String email;
    private String CPF;

    public CadastroCliente() {
    }

    // Construtor com parâmetros para inicializar um cliente já com dados
    public CadastroCliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    // Retorna o ID do cliente
    public long getIdCliente() {
        return idCliente;
    }

    // Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Define ou atualiza o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o e-mail do cliente
    public String getEmail() {
        return email;
    }

    // Define ou atualiza o e-mail do cliente
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o CPF do cliente
    public String getCPF() {
        return CPF;
    }

    // Define ou atualiza o CPF do cliente
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    // Define ou atualiza o ID do cliente
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}