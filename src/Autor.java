package src;

public class Autor {
    private String nome;
    private String nacionalidade;
    private String dataNascimento;

    public Autor(String nome, String nacionalidade, String dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    @Override
    public String toString() {
        return String.format("Autor [Nome: %s, Nacionalidade: %s, Data de Nascimento: %s]",
                nome, nacionalidade, dataNascimento);
    }
}
