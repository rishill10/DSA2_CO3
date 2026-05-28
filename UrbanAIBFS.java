import java.util.*;

public class UrbanAIBFS {

    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    UrbanAIBFS(int vertices) {

        this.vertices = vertices;

        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {

            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add Edge Method
    void addEdge(int source, int destination) {

        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    // BFS Traversal
    void bfs(int startVertex) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;

        queue.add(startVertex);

        System.out.println(
                "\n====== BFS CONNECTIVITY ANALYSIS ======\n");

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();

            System.out.println(
                    "Visited City Zone : "
                  + currentVertex);

            for (int adjacentVertex :
                    adjacencyList[currentVertex]) {

                if (!visited[adjacentVertex]) {

                    visited[adjacentVertex] = true;

                    queue.add(adjacentVertex);
                }
            }
        }
    }

    // Display Smart City Network
    void displayNetwork() {

        System.out.println(
                "\n====== SMART CITY ROAD NETWORK ======\n");

        for (int i = 0; i < vertices; i++) {

            System.out.print(
                    "City Zone "
                  + i
                  + " Connected To : ");

            for (Integer node :
                    adjacencyList[i]) {

                System.out.print(node + " ");
            }

            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        UrbanAIBFS city = new UrbanAIBFS(6);

        // Adding Road Connections
        city.addEdge(0, 1);
        city.addEdge(0, 2);
        city.addEdge(1, 3);
        city.addEdge(2, 4);
        city.addEdge(3, 5);

        // Display Network
        city.displayNetwork();

        // BFS Traversal
        city.bfs(0);

        System.out.println(
                "\n====== SMART CITY CONNECTIVITY ANALYSIS COMPLETED ======");
    }
}
