package src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivrosPorAutor(Autor autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .collect(Collectors.toList());

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
    @Override
    public String toString() {
        return String.format("Biblioteca [Total de livros: %d]", livros.size());
    }

    public List<Livro> getLivros() {
        return List.copyOf(livros);
    }
}
