package univille.gestaoImobiliaria.Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContratoAluguel {
    // Identificador único do contrato no banco
    private long id_contrato;
    // Valor do aluguel contratado
    private BigDecimal valorAluguel;
    // Datas de início e fim do contrato
    private LocalDate dataInicio;
    private LocalDate dataFim;
    // Indica se o contrato está ativo
    private boolean contrato_ativo;
    // Cliente representado pelo CPF
    private CadastroCliente cpf;
    // Cliente vinculado ao contrato
    private CadastroCliente id_cliente;
    // Imóvel vinculado ao contrato
    private CadastroImovel id_imovel;

    // Construtor principal
    public ContratoAluguel(BigDecimal valorAluguel,
                           LocalDate dataInicio, LocalDate dataFim,
                           boolean contrato_ativo, CadastroCliente id_cliente,
                           CadastroImovel id_imovel) {
        this.valorAluguel = valorAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.contrato_ativo = contrato_ativo;
        this.id_cliente= id_cliente;
        this.id_imovel = id_imovel;
    }
    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public long getId_contrato() {
        return id_contrato;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isContrato_ativo() {
        return contrato_ativo;
    }

    public void setContrato_ativo(boolean contrato_ativo) {
        this.contrato_ativo = contrato_ativo;
    }

    public CadastroCliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(CadastroCliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public CadastroCliente getCpf() {
        return cpf;
    }

    public void setCpf(CadastroCliente cpf) {
        this.cpf = cpf;
    }

    public CadastroImovel getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(CadastroImovel id_imovel) {
        this.id_imovel = id_imovel;
    }
}