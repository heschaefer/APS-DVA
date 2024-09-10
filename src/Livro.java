package src;

public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, Autor autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true; //Livro disponivel por padrão
    }

    public void emprestarLivro() {
        if (disponivel) {
            this.disponivel = false;
            System.out.println("Livro emprestado com sucesso!");

        } else {
            System.out.println("Livro indisponível");

        }
    }

    public void devolverLivro() {
        if(disponivel) {
            System.out.println("o livro não está emprestado");
        }

        this.disponivel = true;
        System.out.println("Livro devolvido!");
    }

    public void verificarDisponibilidade() { System.out.println(disponivel ? "Disponível" : "Indisponível"); }

    @Override
    public String toString() {
        return String.format("Título: %s, Autor: %s, ISBN: %s, Disponível: %s",
                titulo, autor.getNome(), isbn, disponivel ? "Sim" : "Não");
    }
    // Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
}

