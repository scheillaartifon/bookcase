import java.util.*;

public class GraphRecommendations {
    public static Map<Book, Integer> djikstraSimple(Map<Book, Map<Book, Integer>> grafo, Book origem) {
        Map<Book, Integer> distance = new HashMap<>();
        Set<Book> visited = new HashSet<>();
        PriorityQueue<Map.Entry<Book, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());

        distance.put(origem, 0);
        queue.add(new AbstractMap.SimpleEntry<>(origem, 0));

        while (!queue.isEmpty()) {
            Book current = queue.poll().getKey();

            if (!visited.add(current)) continue;

            Map<Book, Integer> neighbors = grafo.getOrDefault(current, Collections.emptyMap());

            for (Map.Entry<Book, Integer> entry : neighbors.entrySet()) {
                Book neighbor = entry.getKey();
                int peso = entry.getValue();
                int newDistance = distance.get(current) + peso;

                if (newDistance < distance.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distance.put(neighbor, newDistance);
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor, newDistance));
                }
            }
        }

        return distance;
    }

    public static void recommendations(LinkedList<Book> bookList) {
        Map<Book, Map<Book, Integer>> graphRecommendations = new HashMap<>();
        Set<Book> booksRead = new HashSet<>();
        Map<Book, Integer> recommendedBooks = new HashMap<>();

        for (Book bookMain : bookList) {
            for (Book bookCompared : bookList) {
                if (bookMain != bookCompared) {
                    Integer distance = null;

                    // Quanto menor o numero, mais forte a conexao
                    if (bookMain.getAuthor().equals(bookCompared.getAuthor())) {
                        distance = 1;
                    } else if (bookMain.getGenre() == bookCompared.getGenre()) {
                        distance = 2;
                    } else if (bookMain.getYear() == bookCompared.getYear()) {
                        distance = 3;
                    }

                    if (distance != null) {
                        graphRecommendations.putIfAbsent(bookMain, new HashMap<>());
                        graphRecommendations.putIfAbsent(bookCompared, new HashMap<>());

                        graphRecommendations.get(bookMain).put(bookCompared, distance);
                        graphRecommendations.get(bookCompared).put(bookMain, distance);
                    }
                }
            }
        }

        for (Book book : bookList) {
            if (book.getRead()) {
                booksRead.add(book);
            }
        }

        for (Book book : booksRead) {
            Map<Book, Integer> distances = djikstraSimple(graphRecommendations, book);
            for (Map.Entry<Book, Integer> entry : distances.entrySet()) {
                Book recommended = entry.getKey();
                int distance = entry.getValue();

                if (!recommended.getRead()) {
                    recommendedBooks.put(recommended, Math.min(recommendedBooks.getOrDefault(recommended, Integer.MAX_VALUE), distance));
                }
            }
        }

        System.out.println("\nLivros recomendados com base nas suas leituras:");
        recommendedBooks.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .forEach(entry -> {
                    Book book = entry.getKey();
                    int distancia = entry.getValue();
                    System.out.println("→ Título: " + book.getTitle() +
                            " | Autor: " + book.getAuthor() +
                            " | Gênero: " + book.getGenre() +
                            " | Distância acumulada (peso total): " + distancia);
                });
    }
}
