package univille.gestaoImobiliaria.Entidades;

/**
 * Representa um cliente no sistema de gestão imobiliária.
 */
public class CadastroCliente {
    private long idCliente; // Identificador único do cliente
    private String nome;
    private String email;
    private String CPF; // Cadastro de Pessoa Física

    /**
     * Construtor padrão.
     */
    public CadastroCliente() {
    }

    // Construtor que inicializa os campos principais do cliente
    public CadastroCliente(String nome, String email, String CPF) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
    }

    // Retorna o identificador do cliente
    public long getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    // Permite alterar o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    // Permite alterar o email do cliente
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    // Permite alterar o CPF do cliente
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    // Permite definir o identificador do cliente
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;