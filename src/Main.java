import javax.sound.midi.SysexMessage;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void returnToMenu(Scanner scanner){
        int subOption;

        do {
            System.out.println("\nDigite 0 para voltar ao menu principal.");
            subOption = scanner.nextInt();
        } while (subOption != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Book> bookList = new LinkedList<>();
        Queue<Book> reading_list_year = new LinkedList<>();
        Stack<Integer> reading_history = new Stack<>();
        Book reading = null;

        int count = 1;

        System.out.println("---------- BEM VINDO A ESTANTE DE LIVROS ----------");
        bookList.add(new Book(1, "Corte de Espinhos e Rosas", "Sarah J. Maas", 2015, 434, 1, true));
        bookList.add(new Book(2, "Casa de Terra e Sangue", "Sarah J. Maas", 2020, 803, 1));
        bookList.add(new Book(3, "Trono de Vidro", "Sarah J. Maas", 2012, 392, 1));
        bookList.add(new Book(4, "O Príncipe Cruel", "Holly Black", 2018, 322, 1));
        bookList.add(new Book(5, "O Rei Perverso", "Holly Black", 2019, 336, 1));
        bookList.add(new Book(6, "Novembro, 9", "Colleen Hoover", 2016, 336, 2));
        bookList.add(new Book(7, "É Assim que Acaba", "Colleen Hoover", 2016, 368, 2));
        bookList.add(new Book(8, "Antes de Partir", "Colleen Oakley", 2015, 400, 2));
        bookList.add(new Book(9, "Mil Partes do Meu Coração", "Colleen Hoover", 2018, 384, 2));
        bookList.add(new Book(10, "Os Sete Maridos de Evelyn Hugo", "Taylor Jenkins Reid", 2017, 360, 2));
        bookList.add(new Book(11, "O Lado Feio do Amor", "Colleen Hoover", 2014, 336, 2));
        bookList.add(new Book(12, "O Duque e Eu", "Julia Quinn", 2000, 288, 3));
        bookList.add(new Book(13, "O Visconde Que Me Amava", "Julia Quinn", 2000, 320, 3));
        bookList.add(new Book(14, "Um Perfeito Cavalheiro", "Julia Quinn", 2001, 320, 3));
        bookList.add(new Book(15, "Talvez Você Deva Conversar com Alguém", "Lori Gottlieb", 2020, 448, 4));

        reading = bookList.getFirst();

        while (count != 0) {
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("(1) Ver todos os livros da estante (Lista)");
            System.out.println("(2) Adicionar um novo livro à estante (Lista)");
            System.out.println("(3) Gerenciar lista de leituras do ano (Fila)");
            System.out.println("(4) Gerenciar histórico de leitura do livro lendo (Pilha)");
            System.out.println("(5) Adicionar livro à lidos");
            System.out.println("(6) Ver recomendações a partir de livros lidos (Hashmap)");
            System.out.println("(7) Ver recomendações a partir de livros lidos (Grafos)");
            System.out.println("(8) Excluir livros dos meus livros lidos");

            System.out.print("Digite o número correspondente a opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Opção escolhida foi: " + option);

            if (option == 1) {
                System.out.println("\n----- Ver todos os livros da estante (Lista) -----");
                Book.allBook(bookList);
                returnToMenu(scanner);
            }
            else if (option == 2) {
                System.out.println("\n----- Cadastrar novo livro -----");
                Book.addBook(scanner, bookList);
            }
            else if (option == 3) {
                System.out.println("\n----- Gerenciar lista de leituras do ano (Fila) -----");
                int subOption = 1;

                while (subOption != 0) {
                    System.out.println("\nEscolha uma das opções abaixo:");
                    System.out.println("(1) Adicionar livro à lista de leitura do ano");
                    System.out.println("(2) Ver minha lista de leituras do ano");
                    System.out.println("(3) Iniciar próxima leitura do ano");
                    System.out.print("Digite o número correspondente a opção (0 para sair): ");

                    subOption = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Opção escolhida foi: " + subOption);

                    if (subOption == 1){
                        System.out.println("\n----- Criar minha lista de leituras do ano -----");
                        ReadingListYear.addQueue(scanner, bookList, reading_list_year);
                    } else if (subOption == 2) {
                        System.out.println("\n----- Minha lista de leituras do ano -----");
                        ReadingListYear.allQueue(reading_list_year);
                        returnToMenu(scanner);
                    } else if (subOption == 3) {
                        System.out.println("\n----- Ir para a próxima leitura do ano (Lista de livros que quero ler) -----");
                        ReadingListYear.nextQueue(scanner, reading_list_year, reading);
                    } else {
                        System.out.println("Opção não encontrada\n");
                    }
                }
            }
            else if (option == 4) {
                System.out.println("\n----- Gerenciar histórico de leitura do livro lendo (Pilha) -----");
                int subOption = 1;

                while (subOption != 0) {
                    System.out.println("\nEscolha uma das opções abaixo:");
                    System.out.println("(1) Adicionar histórico de leitura");
                    System.out.println("(2) Remover último registro de histórico");
                    System.out.print("Digite o número correspondente a opção (0 para sair): ");

                    subOption = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Opção escolhida foi: " + subOption);

                    if (subOption == 1) {
                        System.out.println("\n----- Adicionar quantas páginas li do meu livro -----");
                        ReadingHistory.addStack(scanner, reading, reading_history);
                    } else if (subOption == 2) {
                        System.out.println("\n----- Remover último registro de histórico do livro que estou lendo -----");
                        ReadingHistory.removeStack(scanner, reading_history);
                    } else {
                        System.out.println("Opção não encontrada\n");
                    }
                }
            }
            else if (option == 5) {
                System.out.println("\n----- Adicionar livros à lidos -----");
                int subOption;

                do {
                    System.out.print("\nDigite o codigo do livro que deseja marcar como lido (Digite 0 para finalizar): ");
                    subOption = scanner.nextInt();

                    for (Book book : bookList) {
                        if (book.getCodigo() == subOption) {
                            if (book.getRead()) {
                                System.out.println("Livro já cadastrado como lido");
                            } else {
                                book.setRead(true);
                                System.out.println("Cadastrado com sucesso!");

                                GraphRecommendations.recommendations(bookList);
                                returnToMenu(scanner);
                            }
                        }
                    }

                    System.out.println("\nLista de livros atualizada: ");
                    for (Book book : bookList) {
                        if (book.getRead()) {
                            System.out.println(book.getCodigo() + " | " + book.getTitle());
                        }
                    }

                } while (subOption != 0);
            }
            else if (option == 6) {
                System.out.println("\n----- Ver recomendações a partir de livros lidos (Hashmap) -----");
                int fantasyGenre = 0;
                int romanceGenre = 0;
                int historicalRomanceGenre = 0;

                System.out.println("Lista de livros lidos: ");
                for (Book book : bookList) {
                    if (book.getRead()) {
                        System.out.println(book.getCodigo() + " | " + book.getTitle());
                        if (book.getGenre() == 1){
                            fantasyGenre++;
                        } else if (book.getGenre() == 2) {
                            romanceGenre++;
                        } else if (book.getGenre() == 3) {
                            historicalRomanceGenre++;
                        }
                    }
                }

                if (fantasyGenre == 0 && romanceGenre == 0 && historicalRomanceGenre == 0){
                    System.out.println("Você ainda não leu nenhum livro!");
                }

                // Recomendaçõess por gênero
                HashMap<Integer, Book> fantasyBooks = new HashMap<>();
                HashMap<Integer, Book> romanceBooks = new HashMap<>();
                HashMap<Integer, Book> historicalRomanceBooks = new HashMap<>();

                for (Book book : bookList) {
                    if (book.getGenre() == 1 && !book.getRead()) {
                        fantasyBooks.put(book.getCodigo(), book);
                    } else if (book.getGenre() == 2 && !book.getRead()) {
                        romanceBooks.put(book.getCodigo(), book);
                    } else if (book.getGenre() == 3 && !book.getRead()) {
                        historicalRomanceBooks.put(book.getCodigo(), book);
                    }
                }

                System.out.println("\nLivros recomendados para você: ");
                // Identifica o maior valor
                int max = Math.max(fantasyGenre, Math.max(romanceGenre, historicalRomanceGenre));

                if (fantasyGenre == max) {
                    for (Map.Entry<Integer, Book> entry : fantasyBooks.entrySet()) {
                        Book book = entry.getValue();
                        System.out.println("Código: " + book.getCodigo() +
                                ", Título: " + book.getTitle() +
                                ", Autor: " + book.getAuthor() +
                                ", Páginas: " + book.getPages());
                    }
                } else if (romanceGenre == max) {
                    for (Map.Entry<Integer, Book> entry : romanceBooks.entrySet()) {
                        Book book = entry.getValue();
                        System.out.println("Código: " + book.getCodigo() +
                                ", Título: " + book.getTitle() +
                                ", Autor: " + book.getAuthor() +
                                ", Páginas: " + book.getPages());
                    }
                } else {
                    for (Map.Entry<Integer, Book> entry : historicalRomanceBooks.entrySet()) {
                        Book book = entry.getValue();
                        System.out.println("Código: " + book.getCodigo() +
                                ", Título: " + book.getTitle() +
                                ", Autor: " + book.getAuthor() +
                                ", Páginas: " + book.getPages());
                    }
                }

                returnToMenu(scanner);
            }
            else if (option == 7) {
                System.out.println("\n----- Ver recomendações a partir de livros lidos (Grafos) -----");
                GraphRecommendations.recommendations(bookList);
                returnToMenu(scanner);
            }
            else if (option == 8) {
                System.out.println("\n----- Excluir livro lido -----");
                int subOption;

                System.out.println("\nLista de livros lidos: ");
                for (Book book : bookList) {
                    if (book.getRead()) {
                        System.out.println(book.getCodigo() + " | " + book.getTitle());
                    }
                }

                do {
                    System.out.print("\nDigite o codigo do livro que deseja excluir dos lidos (Digite 0 para finalizar): ");
                    subOption = scanner.nextInt();

                    for (Book book : bookList) {
                        if (book.getCodigo() == subOption) {
                            if (book.getRead()) {
                                book.setRead(false);
                            } else {
                                System.out.println("Esse livro não está na sua lista de livros lidos!");
                            }
                        }
                    }

                    System.out.println("\nLista de livros lidos atualizada: ");
                    for (Book book : bookList) {
                        if (book.getRead()) {
                            System.out.println(book.getCodigo() + " | " + book.getTitle());
                        }
                    }

                } while (subOption != 0);
            }
            else {
                System.out.println("Opção não encontrada");
            }
        }

        scanner.close();
    }
}