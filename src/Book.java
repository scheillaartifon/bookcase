import java.util.LinkedList;
import java.util.Scanner;

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

        return this.cod + " | " + this.title + " | " + this.author + " | " + this.year + " | " + this.pages + " | " +
                this.genre + " | " + read + "\n";
    }
}
