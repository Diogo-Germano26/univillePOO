package univille.gestaoImobiliaria.ImobiliariaDL;

public class CadastroImovel {
    private long idImovel;
    private String tipoImovel;
    private String endereco;
    private double tamanho;
    private String classificacao;
    private boolean contratoAlugelAtivo;


    public CadastroImovel() {
    }

    public CadastroImovel(long idImovel, String tipoImovel, String endereco, double tamanho, String classificacao, boolean contratoAlugelAtivo) {
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
        this.endereco = endereco;
        this.tamanho = tamanho;
        this.classificacao = classificacao;
        this.contratoAlugelAtivo =  contratoAlugelAtivo;
    }

    public long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(long idImovel) {
        this.idImovel = idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public boolean isContratoAlugelAtivo() {
        return contratoAlugelAtivo;
    }

    public void setContratoAlugelAtivo(boolean contratoAlugelAtivo) {
        this.contratoAlugelAtivo = contratoAlugelAtivo;
    }
}
