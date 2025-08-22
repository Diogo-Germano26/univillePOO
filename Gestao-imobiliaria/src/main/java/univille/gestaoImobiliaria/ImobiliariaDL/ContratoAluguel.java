package univille.gestaoImobiliaria.ImobiliariaDL;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContratoAluguel {
    private long id_contrato;
    private BigDecimal valorAluguel;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private boolean contrato_ativo;
    private CadastroCliente id_cliente;
    private CadastroImovel id_imovel;

    public ContratoAluguel(){}

    public ContratoAluguel(long id_contrato, BigDecimal valorAluguel,
                           LocalDateTime dataInicio, LocalDateTime dataFim,
                           boolean contrato_ativo, CadastroCliente id_cliente,
                           CadastroImovel id_imovel) {
        this.id_contrato = id_contrato;
        this.valorAluguel = valorAluguel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.contrato_ativo = true;
        this.id_cliente = id_cliente;
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

    public void setId_contrato(long id_contrato) {
        this.id_contrato = id_contrato;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
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

    public CadastroImovel getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(CadastroImovel id_imovel) {
        this.id_imovel = id_imovel;
    }
}
