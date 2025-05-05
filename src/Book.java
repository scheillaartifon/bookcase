import java.util.*;

public class Book {
    LinkedList<Book> bookList = new LinkedList<>();

    private int cod;
    private String title;
    private String author;
    private int year;
    private int pages;
    private int genre;
    private boolean read;

    public Book(int cod, String title, String author, int year, int pages, int genre, boolean read) {
        this.cod = cod;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
        this.read = read;
    }

    // Construtor com gênero opcional (valor padrão: "Indefinido")
    public Book(int cod, String title, String author, int year, int pages, int genre) {
        this.cod = cod;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
    }

    public int getCodigo() {
        return cod;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getGenre() {
        return genre;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String toString() {
        String read;

        if (this.read == true) {
            read = "Lido";
        } else {
            read = "Ainda não li";
        }

        return
            "→ Código: " + this.cod +
            " | Título: " + this.title +
            " | Autor: " + this.author +
            " | Ano: " + this.year +
            " | Páginas: " + this.pages +
            " | Gênero: " + this.genre +
            " | Status: " + read + "\n";
    }

    public static void allBook(LinkedList<Book> bookList) {
        for (Book book : bookList) {
            System.out.print(book);
        }
    }

    public static void addBook(Scanner scanner, LinkedList<Book> bookList) {
        System.out.print("Digite o cod do livro: ");
        int cod = scanner.nextInt();
        scanner.nextLine();

        for (Book book : bookList) {
            if (book.getCodigo() == cod) {
                System.out.println("Já existe um livro com esse código!\n");
                return;
            }
        }

        System.out.print("Digite o nome do livro: ");
        String name = scanner.nextLine().trim();

        System.out.print("Digite o nome do autor(a) do livro: ");
        String author = scanner.nextLine().trim();

        System.out.print("Digite o ano da publicação do livro: ");
        int year = scanner.nextInt();

        int pages;
        do {
            System.out.print("Digite a quantidade de páginas do livro: ");
            if (scanner.hasNextInt()) {
                pages = scanner.nextInt();
                if (pages > 0) break;
                else System.out.println("Número de páginas inválido.");
            } else {
                System.out.println("Digite um número válido para as páginas.");
                scanner.next();
            }
        } while (true);

        int genre;
        do {
            System.out.print("Digite o número referente ao gênero do livro ");
            System.out.print("(1) Fantasia, (2) Romance, (3) Romance de Época, (4) Psicologia: ");
            if (scanner.hasNextInt()) {
                genre = scanner.nextInt();
                if (genre >= 1 && genre <= 3) break;
                else System.out.println("Gênero inválido. Digite 1, 2 ou 3.");
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            }
        } while (true);

        bookList.add(new Book(cod, name, author, year, pages, genre));
        System.out.println("Livro cadastrado com sucesso!");
    }
}
