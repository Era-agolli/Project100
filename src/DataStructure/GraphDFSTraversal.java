package DataStructure;

import utils.InputHelper;

import java.util.*;


// Main class with menu
import java.util.*;

// Graph class with adjacency list and DFS traversal
class GraphDFS {
    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add an edge between two nodes
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Comment this line if the graph is directed
    }

    // Display the adjacency list of the graph
    public void displayGraph() {
        System.out.println("Graph adjacency list:");
        for (var entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Recursive DFS
    public void dfsRecursive(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start node does not exist in the graph.");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Recursive traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Iterative DFS
    public void dfsIterative(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start node does not exist in the graph.");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        System.out.print("DFS Iterative traversal: ");
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                // Push neighbors in reverse order for consistent ordering
                List<Integer> neighbors = adjList.get(node);
                Collections.reverse(neighbors);
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
                Collections.reverse(neighbors); // Restore original order
            }
        }
        System.out.println();
    }
}

// Main class with menu
public class GraphDFSTraversal {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        GraphDFS graphdfs = new GraphDFS();

        while (true) {
            System.out.println("\n--- Graph DFS Menu ---");
            System.out.println("1. Add edges to the graph.");
            System.out.println("2. Perform DFS Recursive traversal.");
            System.out.println("3. Perform DFS Iterative traversal.");
            System.out.println("4. Display the graph.");
            System.out.println("0. Exit.");

            int choice = InputHelper.readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> {
                    int numEdges = InputHelper.readInt(scanner, "Enter the number of edges: ");
                    for (int i = 1; i <= numEdges; i++) {
                        int u = InputHelper.readInt(scanner, "Enter node 1 for edge " + i + ": ");
                        int v = InputHelper.readInt(scanner, "Enter node 2 for edge " + i + ": ");
                        graphdfs.addEdge(u, v);
                        System.out.println("Edge (" + u + ", " + v + ") added.");
                    }
                }
                case 2 -> {
                    int start = InputHelper.readInt(scanner, "Enter the starting node for DFS Recursive: ");
                    graphdfs.dfsRecursive(start);
                }
                case 3 -> {
                    int start = InputHelper.readInt(scanner, "Enter the starting node for DFS Iterative: ");
                    graphdfs.dfsIterative(start);
                }
                case 4 -> graphdfs.displayGraph();
                case 0 -> {
                    System.out.println("Exiting Graph Menu.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
