package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Biblioteca {
    private final List<Livro> livros;
    private final List<Autor> autores;
    private final List<Membro> membros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        if (!autores.contains(livro.getAutor())) {
            autores.add(livro.getAutor());
        }
    }
    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }
    public List<Livro> listarLivrosPorAutor(Autor autor) {
        List<Livro> listaPorAutor = livros.stream()
                .filter(livro -> {
                    boolean mesmoAutor = livro.getAutor().equals(autor);
                    if (mesmoAutor) {
                        System.out.println("Comparação autor realizada com sucesso: " + livro.getAutor().getNome());
                    }
                    return mesmoAutor;
                })
                .collect(Collectors.toList());

        System.out.println("Livros encontrados: " + listaPorAutor.size());
        return listaPorAutor;
    }
    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return livros.stream()
            .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
            .collect(Collectors.toList());
    }
    public Livro buscarLivroPorISBN(String isbn) {
        return livros.stream()
                .filter(livro -> livro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
    public List<Autor> listarAutores() {
        return new ArrayList<>(autores);
    }
    @Override
    public String toString() {
        return String.format("Biblioteca [Total de livros: %d, Total de autores: %d, Total de membros: %d]",
                livros.size(), autores.size(), membros.size());
    }

    public List<Livro> getLivros() {
        return List.copyOf(livros);
    }
    public void registrarEmprestimo(String idMembro, String isbn) {
        Optional<Membro> membro = membros.stream().filter(m -> m.getIdMembro().equals(idMembro)).findFirst();
        Livro livro = buscarLivroPorISBN(isbn);

        if (membro.isPresent() && livro != null && !livro.isDisponivel()) {
            membro.get().adicionarEmprestimo(livro);
            livro.emprestarLivro();
            System.out.println("Empréstimo registrado com sucesso.");
        } else {
            System.out.println("Empréstimo não pôde ser registrado.");
        }
    }
    public void registrarDevolucao(String idMembro, String isbn) {
        Optional<Membro> membro = membros.stream().filter(m -> m.getIdMembro().equals(idMembro)).findFirst();
        Livro livro = buscarLivroPorISBN(isbn);

        if (membro.isPresent() && livro != null && !livro.isDisponivel()) {
            livro.devolverLivro();
            System.out.println("Devolução registrada com sucesso.");
        } else {
            System.out.println("Devolução não pôde ser registrada.");
        }
    }
}
