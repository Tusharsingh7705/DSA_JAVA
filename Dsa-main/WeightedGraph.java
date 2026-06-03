import java.util.*;

public class WeightedGraph {

    public static void main(String[] args) {
        int n = 6;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 7);
        addEdge(graph, 0, 5, 5);
        addEdge(graph, 1, 0, 2);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 2, 5, 3);
        addEdge(graph, 5, 2, 2);
        addEdge(graph, 5, 4, 1);
        addEdge(graph, 4, 5, 1);
        addEdge(graph, 4, 3, 2);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 3, 0, 7);

        printGraph(graph);
    }

    public static void addEdge(ArrayList<ArrayList<int[]>> graph, int u, int v, int w) {
        graph.get(u).add(new int[]{v, w});
        graph.get(v).add(new int[]{u, w});
    }

    public static void printGraph(ArrayList<ArrayList<int[]>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int[] edge : graph.get(i)) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }
}
