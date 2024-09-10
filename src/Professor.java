package src;

public class Professor extends Membro {
    private String departamento;

    public Professor(String nome, String idMembro, String departamento) {
        super(nome, idMembro);
        this.departamento = departamento;
    }
    // Getter
    public String getDepartamento() {
        return departamento;
    }
    @Override
    public String toString() {
        return String.format("Professor [Nome: %s, ID: %s, Departamento: %s, Empréstimos: %d]",
                getNome(), getIdMembro(), departamento, getHistoricoEmprestimos().size());
    }
}
