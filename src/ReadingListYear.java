import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class ReadingListYear {
    public static void allQueue(Queue<Book> reading_list_year) {
        if (reading_list_year.isEmpty()) {
            System.out.println("Você ainda não tem uma meta de leitura cadastrada");
        } else {
            for (Object o : reading_list_year) {
                System.out.print(o);
            }
        }
    }

    public static void addQueue(Scanner scanner, LinkedList<Book> bookList, Queue<Book> reading_list_year) {
        int subOption;

        do {
            System.out.print("Digite o codigo do livro que deseja ler (Digite 0 para finalizar): ");
            subOption = scanner.nextInt();

            for (Book book : bookList) {
                if (book.getCodigo() == subOption) {
                    reading_list_year.add(book);
                    System.out.println("Adicionado livro '" + book.getTitle() + "' a meta do ano");
                }
            }
        } while (subOption != 0);
    }

    public static void nextQueue(Scanner scanner, Queue<Book> reading_list_year, Book reading) {
        int subOption;

        do {
            if (reading_list_year.isEmpty()){
                System.out.println("Você não tem nenhum livro cadastrado na meta anual de leitura");
            } else {
                System.out.println("\nSua lista de próxima(s) leitura(s) é: ");

                int index = 1;
                for (Book livro : reading_list_year) {
                    System.out.println(index + " - " + livro.getTitle());
                    index++;
                }

                System.out.println("\nDigite 1 para adicionar o primeiro livro a 'lendo' (Excluir da fila)");
                subOption = scanner.nextInt();

                if (subOption == 1) {
                    reading = reading_list_year.element();
                    reading_list_year.remove();
                    System.out.println("Livro '" + reading.getTitle() + "' movido para lendo\n");
                }
            }

            System.out.println("Digite 0 para voltar ao menu principal");
            subOption = scanner.nextInt();
        } while (subOption != 0);
    }
}