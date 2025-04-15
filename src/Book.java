public class Book {
    private int cod;
    private String title;
    private String author;
    private int year;

    public Book(int cod, String title, String author, int year) {
        this.cod = cod;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getCodigo() {
        return cod;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return this.cod + " - " + this.title + " - " + this.author + " - " + this.year + "\n";
    }
}
