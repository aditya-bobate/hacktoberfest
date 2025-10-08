import java.util.*;

class Graph {
    private int vertices; // number of vertices
    private LinkedList<Integer>[] adjList; // adjacency list

    // Constructor
    Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge
    void addEdge(int src, int dest) {
        adjList[src].add(dest); // Directed graph
        // For undirected graph, also add: adjList[dest].add(src);
    }

    // BFS traversal
    void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS traversal
    void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}

public class AdvancedDataStructure_GraphExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices in graph: ");
        int v = sc.nextInt();
        Graph graph = new Graph(v);

        System.out.println("Enter edges (src dest). Type -1 -1 to stop:");
        while (true) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            if (src == -1 && dest == -1) break;
            graph.addEdge(src, dest);
        }

        System.out.print("Enter start node for BFS and DFS: ");
        int start = sc.nextInt();

        graph.BFS(start);
        graph.DFS(start);

        sc.close();
    }
}
