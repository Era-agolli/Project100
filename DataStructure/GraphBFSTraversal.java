package DataStructure;

import utils.InputHelper;

import java.util.*;

import java.util.*;

// Graph class with adjacency list and BFS traversal
class Graph {
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add an edge between two nodes
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Comment this line if directed graph
    }

    // Display the graph
    public void displayGraph() {
        System.out.println("Graph adjacency list:");
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Perform BFS traversal from a given start node
    public void bfs(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start node does not exist in the graph.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// Main class
public class GraphBFSTraversal {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        while (true) {
            System.out.println("\n--- Graph BFS Menu ---");
            System.out.println("1. Add edges to the graph.");
            System.out.println("2. Perform BFS traversal.");
            System.out.println("3. Display the graph.");
            System.out.println("0. Exit.");

            int choice = InputHelper.readInt(scanner, "Choose your option: ");

            switch (choice) {
                case 1 -> {
                    int numEdges = InputHelper.readInt(scanner, "Enter the number of edges: ");
                    for (int i = 1; i <= numEdges; i++) {
                        int u = InputHelper.readInt(scanner, "Enter node 1 for edge " + i + ": ");
                        int v = InputHelper.readInt(scanner, "Enter node 2 for edge " + i + ": ");
                        graph.addEdge(u, v);
                        System.out.println("Edge (" + u + ", " + v + ") added.");
                    }
                }
                case 2 -> {
                    int start = InputHelper.readInt(scanner, "Enter the starting node for BFS: ");
                    graph.bfs(start);
                }
                case 3 -> graph.displayGraph();
                case 0 -> {
                    System.out.println("Exiting Graph Menu.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
