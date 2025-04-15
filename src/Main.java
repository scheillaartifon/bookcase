import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Book> bookList = new LinkedList<>();
        Queue<Book> wantToRead = new LinkedList<>();
        Stack<Integer> lastBooksVisited = new Stack<>();
        Book reading = null;

        int count = 1;

        System.out.println("\nBem vindo a Biblioteca. Digite a ação que gostaria de fazer");
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

        reading = bookList.get(0);

        while (count != 0) {
            System.out.println("\nDigite o número correspondente a ação abaixo:");
            System.out.println("1 - Ver lista de livros cadastrados na minha estante (lista)");
            System.out.println("2 - Adicionar novo livro na minha estante (lista)");
            System.out.println("3 - Quero ler - Criar minha lista de leitura do ano (fila)");
            System.out.println("4 - Quero ler - Ver minha lista de leituras do ano (fila)");
            System.out.println("5 - Quero ler - Ir para a próxima leitura do ano (fila)");
            System.out.println("6 - Lendo - Adicionar histórico de leitura (pilha)");
            System.out.println("7 - Lendo - Excluir histórico de leitura (pilha)");

            System.out.print("Digite o número correspondente a opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\nOpção escolhida foi: " + option);

            if (option == 1) {
                int subOption;
                do {
                    System.out.println("\n----- Lista de livros cadastrados -----");
                    for (Object o : bookList) {
                        System.out.print(o);
                    }

                    System.out.println("\nDigite 0 para voltar ao menu principal.");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 2) {
                int subOption;
                do {
                    System.out.println("\n----- Cadastrar novo livro -----");
                    System.out.print("Digite o cod do livro: ");
                    int cod = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do livro: ");
                    String name = scanner.nextLine();

                    System.out.print("Digite o nome do autor(a) do livro: ");
                    String author = scanner.nextLine();

                    System.out.print("Digite o ano da publicação do livro: ");
                    int year = scanner.nextInt();

                    try {
                        bookList.add(new Book(cod, name, author, year));
                        System.out.print("Livro cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.print("Não foi possível cadastrar.");
                    }

                    System.out.println("\nDigite 0 para voltar ao menu principal.");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 3) {
                System.out.println("\n----- Criar minha lista de leituras do ano -----");
                int subOption;
                do {
                    System.out.print("Digite o codigo do livro que deseja ler (Digite 0 para finalizar): ");
                    subOption = scanner.nextInt();

                    for (int i = 0; i < bookList.size(); i++){
                        if (bookList.get(i).getCodigo() == subOption) {
                            wantToRead.add(bookList.get(i));
                            System.out.println("Adicionado livro '" + bookList.get(i).getTitle() + "' a meta do ano");
                        }
                    }
                } while (subOption != 0);
            }
            else if (option == 4) {
                System.out.println("\n----- Minha lista de leituras do ano -----");

                int subOption;
                do {
                    if (wantToRead.isEmpty()){
                        System.out.println("Você ainda não tem uma meta de leitura cadastrada");
                    } else {
                        for (Object o : wantToRead) {
                            System.out.print(o);
                        }
                    }
                    System.out.println("\nDigite 0 para voltar ao menu principal.");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 5) {
                int subOption;
                System.out.println("\n----- Ir para a próxima leitura do ano (Lista de livros que quero ler) -----");

                do {
                    if (wantToRead.isEmpty()){
                        System.out.println("Você não tem nenhum livro cadastrado na meta anual de leitura");
                    } else {
                        System.out.println("\nSua lista de próxima(s) leitura(s) é: ");

                        int index = 1;
                        for (Book livro : wantToRead) {
                            System.out.println(index + " - " + livro.getTitle());
                            index++;
                        }

                        System.out.println("\nDigite 1 para adicionar o primeiro livro a 'lendo' (Excluir da fila)");
                        subOption = scanner.nextInt();

                        if (subOption == 1) {
                            reading = wantToRead.element();
                            wantToRead.remove();
                            System.out.println("Livro '" + reading.getTitle() + "' movido para lendo\n");
                        }
                    }

                    System.out.println("Digite 0 para voltar ao menu principal");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 6) {
                int subOption = 1;
                int value = 0;

                System.out.println("\n----- Adicionar quantas páginas li do meu livro (pilha) -----");
                System.out.println("Livro que estou lendo: " + reading.getTitle());

                if (lastBooksVisited.isEmpty()){
                    System.out.print("Você ainda não adicionou nenhum histórico de leitura.\n");
                } else {
                    System.out.println("Histórico adicionado anteriormente: ");
                    for (int pages : lastBooksVisited) {
                        System.out.println(pages);
                    }
                }

                do {
                    System.out.print("\nDigite quantas páginas já leu até o momento (Digite 0 para finalizar): ");
                    value = scanner.nextInt();

                    if (value == 0){
                        subOption = 0;
                    } else {
                        lastBooksVisited.add(value);
                    }

                    System.out.println(lastBooksVisited);
                } while (subOption != 0);
            }
            else if (option == 7) {
                int subOption = 1;

                do {
                    if (lastBooksVisited.isEmpty()){
                        System.out.println("Você ainda não adicionou um histórico de leitura");
                    } else {
                        System.out.println("\nSeu histórico de leitura é: ");
                        for (int pages : lastBooksVisited) {
                            System.out.println(pages);
                        }

                        System.out.print("\nDigite 1 para excluir o último valor do histórico (Excluir da pilha): ");
                        subOption = scanner.nextInt();

                        if (subOption == 1) {
                            lastBooksVisited.pop();
                        }
                    }

                    System.out.println("\nDigite 0 para voltar ao menu principal ou qualquer numero para continuar");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else {
                System.out.println("Opção não encontrada");
            }
        }

        scanner.close();
    }
}