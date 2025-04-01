import java.util.LinkedList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    int year;

    Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + author + " - " + year + "\n";
    }
}

// Emprestar livro (Usando lista)
class LendBook {
    private LinkedList<Integer> lista = new LinkedList<Integer>();

    // Adiciona elemento na fila
    public void reservation(int valor) { // Fila de reserva de um livro
        lista.addLast(valor);
        System.out.print(valor + " ");
    }

    public int devolution() { // Devolucao da reserva
        if (!estaVazia()) {
            return lista.removeFirst(); // Remove do início da lista
        } else {
            System.out.println("Fila vazia!");
            return -1; // Indicando erro
        }
    }

    // Verifica se a fila está vazia
    public boolean estaVazia() {
        return lista.isEmpty();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Object> bookList = new LinkedList<Object>();

        Book book1 = new Book(1, "Corte de Espinhos e Rosas", "Sarah J. Maas", 2015);
        Book book2 = new Book(2, "Casa de Terra e Sangue", "Sarah J. Maas", 2020);
        Book book3 = new Book(3, "Trono de Vidro", "Sarah J. Maas", 2012);
        Book book4 = new Book(4, "O Príncipe Cruel", "Holly Black", 2018);
        Book book5 = new Book(5, "Divinos Rivais", "Rebecca Ross", 2023);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        System.out.println("\nLista de livros cadastrados");
        System.out.println(bookList);

        bookList.remove(book1);
        System.out.println("\nRemovido primeiro livro da estante (Corte de Espinhos e)");

        System.out.println("Lista atualizada de livros cadastrados");
        System.out.println(bookList);

        System.out.println("\nAdicionado usuários para fila de espera do livro");
        LendBook reservationQueue = new LendBook();
        reservationQueue.reservation(3);
        reservationQueue.reservation(1);
        reservationQueue.reservation(2);
        reservationQueue.reservation(4);
        reservationQueue.reservation(5);

        System.out.println("\n\nLivro devolvido...");
        while (!reservationQueue.estaVazia()) {
            System.out.println(
                    "Usuário " + reservationQueue.devolution() + " era o próximo da fila para reservar livro");
            System.out.println("Usuário não quis reservar o livro. Próximo...");
        }

    }
}
