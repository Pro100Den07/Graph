import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Додає вершину до графу
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Додає ребро між двома вершинами
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Для неорієнтованого графу
    }

    // Видаляє вершину з графу
    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            adjacencyList.remove(vertex);
            for (Set<Integer> neighbors : adjacencyList.values()) {
                neighbors.remove(vertex);
            }
        }
    }

    // Видаляє ребро між двома вершинами
    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            adjacencyList.get(source).remove(destination);
            adjacencyList.get(destination).remove(source);
        }
    }

    // Перевіряє, чи існує вершина у графі
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Перевіряє, чи існує ребро між двома вершинами у графі
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    // Метод для демонстрації роботи з графом
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Додаємо вершини
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Додаємо ребра
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Перевірка існування вершин та ребер
        System.out.println("Чи існує вершина 1: " + graph.hasVertex(1)); // true
        System.out.println("Чи існує вершина 5: " + graph.hasVertex(5)); // false
        System.out.println("Чи існує ребро між 1 та 2: " + graph.hasEdge(1, 2)); // true
        System.out.println("Чи існує ребро між 1 та 4: " + graph.hasEdge(1, 4)); // false

        // Видалення вершини та ребра
        graph.removeVertex(2);
        graph.removeEdge(1, 3);

        // Перевірка після видалення
        System.out.println("Чи існує вершина 2: " + graph.hasVertex(2)); // false
        System.out.println("Чи існує ребро між 1 та 3: " + graph.hasEdge(1, 3)); // false
    }
}