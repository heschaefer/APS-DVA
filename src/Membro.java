package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Membro {
    private String nome;
    private String idMembro;
    private List<Livro> historicoEmprestimos;

    public Membro(String nome, String idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.historicoEmprestimos = new ArrayList<>();
    }



    public void registrarEmprestimo(Livro livro) {
        if (livro.emprestarLivro()) {
            historicoEmprestimos.add(livro);
        }
    }

    public void registrarDevolucao(Livro livro) {
        if (historicoEmprestimos.contains(livro)) {
            livro.devolverLivro();
        }
        else System.out.println("Este livro não está no histórico de empréstimos deste membro.");
    }
    //Getts
    public String getNome() {
        return nome;
    }

    public String getIdMembro() {
        return idMembro;
    }

    public List<Livro> getHistoricoEmprestimos() {
        return Collections.unmodifiableList(historicoEmprestimos);
    }

    @Override
    public String toString() {
        return String.format("Membro [Nome: %s, ID: %s, Empréstimos: %d]",
                nome, idMembro, historicoEmprestimos.size());
    }
}

