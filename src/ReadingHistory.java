import java.util.Scanner;
import java.util.Stack;

public class ReadingHistory {
    public static void addStack(Scanner scanner, Book reading, Stack<Integer> reading_history){
        System.out.println("Livro que estou lendo: " + reading.getTitle());

        int subOption = 1;
        int value = 0;

        if (reading_history.isEmpty()){
            System.out.print("Você ainda não adicionou nenhum histórico de leitura.\n");
        } else {
            System.out.println("Histórico adicionado anteriormente: ");
            for (int pages : reading_history) {
                System.out.println(pages);
            }
        }

        do {
            System.out.print("\nDigite quantas páginas já leu até o momento (Digite 0 para finalizar): ");
            value = scanner.nextInt();

            if (value == 0){
                subOption = 0;
            } else {
                reading_history.add(value);
            }

            System.out.println(reading_history);
        } while (subOption != 0);
    }

    public static void removeStack(Scanner scanner, Stack<Integer> reading_history){
        int subOption = 1;

        do {
            if (reading_history.isEmpty()){
                System.out.println("Você ainda não adicionou um histórico de leitura");
            } else {
                System.out.println("\nSeu histórico de leitura é: ");
                for (int pages : reading_history) {
                    System.out.println(pages);
                }

                System.out.print("\nDigite 1 para excluir o último valor do histórico (Excluir da pilha): ");
                subOption = scanner.nextInt();

                if (subOption == 1) {
                    reading_history.pop();
                }
            }

            System.out.println("\nDigite 0 para voltar ao menu principal ou qualquer numero para continuar");
            subOption = scanner.nextInt();
        } while (subOption != 0);
    }
}
