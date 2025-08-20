package univille.biblioteca.entidade;

import java.sql.Date;
import java.time.LocalDateTime;

public class Emprestimo{
    private long id_emprestimo;
    private long idUsuario;
    private LocalDateTime data_emprestimo;
    private LocalDateTime data_prevista_devolucao;
    private LocalDateTime data_efetiva_devolucao;

    public long getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(long id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDateTime data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDateTime getData_prevista_devolucao() {
        return data_prevista_devolucao;
    }

    public void setData_prevista_devolucao(Date data_prevista_devolucao) {
        this.data_prevista_devolucao = data_prevista_devolucao;
    }

    public LocalDateTime getData_efetiva_devolucao() {
        return data_efetiva_devolucao;
    }

    public void setData_efetiva_devolucao(LocalDateTime data_efetiva_devolucao) {
        this.data_efetiva_devolucao = data_efetiva_devolucao;
    }
}
