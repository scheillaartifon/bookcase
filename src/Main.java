import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Book> bookList = new LinkedList<>();
        Queue<Book> reading_list_year = new LinkedList<>();
        Stack<Integer> reading_history = new Stack<>();
        HashMap<Integer, LinkedList<Book>> recommendations = new HashMap<>();
        Book reading = null;

        int count = 1;

        System.out.println("---------- BEM VINDO A ESTANTE DE LIVROS ----------");
        Book book1 = new Book(1, "Corte de Espinhos e Rosas", "Sarah J. Maas", 2015, 434, 1);
        Book book2 = new Book(2, "Casa de Terra e Sangue", "Sarah J. Maas", 2020, 803, 1);
        Book book3 = new Book(3, "Trono de Vidro", "Sarah J. Maas", 2012, 392, 1);
        Book book4 = new Book(4, "O Príncipe Cruel", "Holly Black", 2018, 322, 1);
        Book book5 = new Book(5, "O Rei Perverso", "Holly Black", 2019, 336, 1);
        Book book6 = new Book(6, "Novembro, 9", "Colleen Hoover", 2016, 336, 2);
        Book book7 = new Book(7, "É Assim que Acaba", "Colleen Hoover", 2016, 368, 2);
        Book book8 = new Book(8, "O Duque e Eu", "Julia Quinn", 2000, 288, 3);
        Book book9 = new Book(9, "O Visconde Que Me Amava", "Julia Quinn", 2000, 320, 3);
        Book book10 = new Book(10, "Um Perfeito Cavalheiro", "Julia Quinn", 2001, 320, 3);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);

        reading = bookList.get(0);

        while (count != 0) {
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("(1) Ver todos os livros da estante (Lista)");
            System.out.println("(2) Adicionar um novo livro à estante (Lista)");
            System.out.println("(4) Ver minha lista de leituras do ano (Fila)");
            System.out.println("(3) Adicionar livro à lista de leitura do ano (Fila)");
            System.out.println("(5) Iniciar próxima leitura do ano (Fila)");
            System.out.println("(6) Adicionar histórico de leitura do livro que estou lendo (Pilha)");
            System.out.println("(7) Remover último registro de histórico do livro que estou lendo (Pilha)");
            System.out.println("(8) Ver todos os livros lidos + recomendações de próximas leituras (Grafos)");
            System.out.println("(9) Adicionar livro à lidos");
            System.out.println("(10) Excluir livros dos meus livros lidos");

            System.out.print("Digite o número correspondente a opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Opção escolhida foi: " + option);

            if (option == 1) {
                System.out.println("\n----- Lista de livros cadastrados -----");
                int subOption;

                do {
                    for (Object o : bookList) {
                        System.out.print(o);
                    }

                    System.out.println("\nDigite 0 para voltar ao menu principal.");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 2) {
                System.out.println("\n----- Cadastrar novo livro -----");
                int subOption = 1;

                do {
                    System.out.print("Digite o cod do livro: ");
                    int cod = scanner.nextInt();
                    scanner.nextLine();
                    for (Book book : bookList) {
                        if (book.getCodigo() == cod) {
                            System.out.println("Já existe um livro com esse código! \n");
                            subOption = 0;
                        }
                    }

                    if (subOption != 0) {
                        System.out.print("Digite o nome do livro: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Digite o nome do autor(a) do livro: ");
                        String author = scanner.nextLine().trim();

                        System.out.print("Digite o ano da publicação do livro: ");
                        int year = scanner.nextInt();

                        int pages = 0;
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

                        int genre = 0;
                        do {
                            System.out.print("Digite o número referente ao gênero do livro ");
                            System.out.print("(1) Fantasia, (2) Romance, (3) Romance de Época: ");
                            if (scanner.hasNextInt()) {
                                genre = scanner.nextInt();
                                if (genre >= 1 && genre <= 3) break;
                                else System.out.println("Gênero inválido. Digite 1, 2 ou 3.");
                            } else {
                                System.out.println("Entrada inválida. Digite um número.");
                                scanner.next();
                            }
                        } while (true);

                        try {
                            bookList.add(new Book(cod, name, author, year, pages, genre));
                            System.out.print("Livro cadastrado com sucesso!");
                        } catch (Exception e) {
                            System.out.print("Não foi possível cadastrar.");
                        }

                        System.out.println("\nDigite 0 para voltar ao menu principal.");
                        subOption = scanner.nextInt();
                    }
                } while (subOption != 0);
            }
            else if (option == 3) {
                System.out.println("\n----- Minha lista de leituras do ano -----");
                int subOption;

                do {
                    if (reading_list_year.isEmpty()){
                        System.out.println("Você ainda não tem uma meta de leitura cadastrada");
                    } else {
                        for (Object o : reading_list_year) {
                            System.out.print(o);
                        }
                    }
                    System.out.println("\nDigite 0 para voltar ao menu principal.");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 4) {
                System.out.println("\n----- Criar minha lista de leituras do ano -----");
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
            else if (option == 5) {
                System.out.println("\n----- Ir para a próxima leitura do ano (Lista de livros que quero ler) -----");
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
            else if (option == 6) {
                System.out.println("\n----- Adicionar quantas páginas li do meu livro (pilha) -----");
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
            else if (option == 7) {
                System.out.println("\n----- Remover último registro de histórico do livro que estou lendo (Pilha) -----");
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
            else if (option == 8) {
                System.out.println("\n----- Ver recomendações de livros lidos -----");
                int subOption;
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

                do {
                    System.out.println("\nDigite 0 para voltar ao menu principal ou qualquer numero para continuar");
                    subOption = scanner.nextInt();
                } while (subOption != 0);
            }
            else if (option == 9) {
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
            else if (option == 10) {
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