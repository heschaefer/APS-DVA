package src;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // consome o caractere newline

            switch (option) {
                case 1:
                    adicionarLivro(scanner);
                    break;
                case 2:
                    listarLivrosPorAutor(scanner);
                    break;
                case 3:
                    buscarLivrosPorTitulo(scanner);
                    break;
                case 4:
                    listarTodosOsLivros();
                    break;
                case 5:
                    buscarLivroPorISBN(scanner);
                    break;
                case 6:
                    adicionarMembro(scanner);
                    break;
                case 7:
                    registrarEmprestimo(scanner);
                    break;
                case 8:
                    listarTodosOsAutores();
                    break;
                case 9:
                    registrarDevolucao(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Biblioteca Menu:");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Listar Livros por Autor");
        System.out.println("3. Buscar Livros por Título");
        System.out.println("4. Listar Todos os Livros");
        System.out.println("5. Buscar Livro por ISBN");
        System.out.println("6. Adicionar Membro");
        System.out.println("7. Registrar Empréstimo");
        System.out.println("8. Listar Todos os Autores");
        System.out.println("9. Registrar Devolução");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarLivro(Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine().trim();

        System.out.print("Digite a nacionalidade do autor: ");
        String nacionalidade = scanner.nextLine().trim();

        System.out.print("Digite a data de nascimento do autor: ");
        String dataNascimento = scanner.nextLine().trim();

        Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine().trim();

        Livro livro = new Livro(titulo, autor, isbn);
        biblioteca.adicionarLivro(livro);

        System.out.println("Livro adicionado com sucesso!");
    }

    private static void listarLivrosPorAutor(Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine().trim();

        System.out.print("Digite a nacionalidade do autor: ");
        String nacionalidade = scanner.nextLine().trim();

        System.out.print("Digite a data de nascimento do autor: ");
        String dataNascimento = scanner.nextLine().trim();

        Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

        System.out.println("Procurando livros para o autor: " + autor);
        List<Livro> livros = biblioteca.listarLivrosPorAutor(autor);

        System.out.println("Livros encontrados: " + livros.size());
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para este autor.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private static void buscarLivrosPorTitulo(Scanner scanner) {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine().trim();

        List<Livro> livros = biblioteca.buscarLivrosPorTitulo(titulo);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com este título.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private static void listarTodosOsLivros() {
        List<Livro> livros = biblioteca.getLivros();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível na biblioteca.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private static void buscarLivroPorISBN(Scanner scanner) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine().trim();

        Livro livro = biblioteca.buscarLivroPorISBN(isbn);

        if (livro == null) {
            System.out.println("Nenhum livro encontrado com este ISBN.");
        } else {
            System.out.println(livro);
        }
    }

    private static void adicionarMembro(Scanner scanner) {
        System.out.println("1. Adicionar Estudante");
        System.out.println("2. Adicionar Professor");
        System.out.print("Escolha o tipo de membro: ");

        int tipoMembro = scanner.nextInt();
        scanner.nextLine(); // consome o caractere newline

        System.out.print("Digite o nome do membro: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Digite o ID do membro: ");
        String idMembro = scanner.nextLine().trim();

        switch (tipoMembro) {
            case 1:
                System.out.print("Digite o curso do estudante: ");
                String curso = scanner.nextLine().trim();
                Estudante estudante = new Estudante(nome, idMembro, curso);
                biblioteca.adicionarMembro(estudante);
                System.out.println("Estudante adicionado com sucesso!");
                break;
            case 2:
                System.out.print("Digite o departamento do professor: ");
                String departamento = scanner.nextLine().trim();
                Professor professor = new Professor(nome, idMembro, departamento);
                biblioteca.adicionarMembro(professor);
                System.out.println("Professor adicionado com sucesso!");
                break;
            default:
                System.out.println("Tipo de membro inválido.");
        }
    }

    private static void registrarEmprestimo(Scanner scanner) {
        System.out.print("Digite o ID do membro: ");
        String idMembro = scanner.nextLine().trim();

        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine().trim();

        biblioteca.registrarEmprestimo(idMembro, isbn);
    }

    private static void registrarDevolucao(Scanner scanner) {
        System.out.print("Digite o ID do membro: ");
        String idMembro = scanner.nextLine().trim();

        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine().trim();

        biblioteca.registrarDevolucao(idMembro, isbn);
    }

    private static void listarTodosOsAutores() {
        List<Autor> autores = biblioteca.listarAutores();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado na biblioteca.");
        } else {
            autores.forEach(System.out::println);
        }
    }
}