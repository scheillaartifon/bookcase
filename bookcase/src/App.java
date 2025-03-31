class Node {
    int id;
    int year;
    String title;
    String author;
    Node next;

    public Node(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void add(int id, String title, String author, int year) {
        Node newNode = new Node(id, title, author, year);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void delete(int id) {
        if (head == null)
            return;

        if (head.id == id) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }

        if (current.next == null)
            return;

        current.next = current.next.next;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.title + " -> ");
            current = current.next;
        }

        System.out.println("null \n");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList bookList = new LinkedList();

        bookList.add(1, "Corte de Espinhos e Rosas", "Sarah J. Maas", 2015);
        bookList.add(2, "Casa de Terra e Sangue", "Sarah J. Maas", 2020);
        bookList.add(3, "Trono de Vidro", "Sarah J. Maas", 2012);
        bookList.add(4, "O Príncipe Cruel", "Holly Black", 2018);
        bookList.add(5, "Divinos Rivais", "Rebecca Ross", 2023);

        System.out.println("Lista encadeada de livros:");
        bookList.printList();

        bookList.delete(3);
        System.out.println("Lista após remover o livro Trono de Vidro (id 3):");
        bookList.printList();
    }
}
