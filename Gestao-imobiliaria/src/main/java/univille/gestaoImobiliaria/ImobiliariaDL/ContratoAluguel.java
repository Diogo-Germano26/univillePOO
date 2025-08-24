package univille.gestaoImobiliaria.ImobiliariaDL;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContratoAluguel {
    private long id_contrato;
    private BigDecimal valorAluguel;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean contrato_ativo;
    private CadastroCliente cpf;
    private CadastroCliente id_cliente;
    private CadastroImovel id_imovel;

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