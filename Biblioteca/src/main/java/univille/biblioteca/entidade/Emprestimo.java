package univille.biblioteca.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo{
    private long id_emprestimo;
    private long idUsuario;
    private LocalDateTime data_emprestimo;
    private LocalDateTime data_prevista_devolucao;
    private LocalDateTime data_efetiva_devolucao;


}
