import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Object> bookList = new LinkedList<Object>();
        Queue<String> reservationQueue = new PriorityQueue<>();
        Stack<Integer> lastBooksVisited = new Stack<>();

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
        for (int i = 0; i < bookList.size(); i++) {
            System.out.print(bookList.get(i));
        }

        bookList.remove(book1);
        System.out.println(
                "\nRemovido primeiro livro da estante (Corte de Espinhos e Rosas). Agora a lista atualizada ficou:");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.print(bookList.get(i));
        }

        System.out.println("\nAdicionado usuário na fila de espera para pegar o livro 1");
        reservationQueue.add("Ana");
        reservationQueue.add("Marcos");
        reservationQueue.add("Fabricio");
        reservationQueue.add("Morgana");
        reservationQueue.add("Sara");

        System.out.println("Livro devolvido...");
        while (!reservationQueue.isEmpty()) {
            System.out.println(
                    "Usuário " + reservationQueue.remove() + " era o próximo da fila para reservar livro");
            System.out.println("Usuário não quis reservar o livro. Próximo...");
        }

        System.out.println("\nÚltimos livros visitados");
        lastBooksVisited.add(1);
        lastBooksVisited.add(3);
        lastBooksVisited.add(5);
        lastBooksVisited.add(2);
        lastBooksVisited.add(4);

        while (!lastBooksVisited.isEmpty()) {
            System.out.println("Excluido livro " + lastBooksVisited.pop() + " que foi o último visitado");
        }
    }
}
