package src;

public class Estudante extends Membro {
    private String curso;

    public Estudante(String nome, String idMembro, String curso) {
        super(nome, idMembro);
        this.curso = curso;
    }

    // Getter
    public String getCurso() {
        return curso;
    }
    @Override
    public String toString() {
        return String.format("Estudante [Nome: %s, ID: %s, Curso: %s, Empréstimos: %d]",
                getNome(), getIdMembro(), curso, getHistoricoEmprestimos().size());
    }
}

