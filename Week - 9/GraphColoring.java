import java.util.*;

public class GraphColoring {

    static boolean isSafe(int v, int[][] graph, int[] color, int c, int V) {

        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        }
        return true;
    }

    static boolean solve(int[][] graph, int m, int[] color, int v, int V) {

        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {

            if (isSafe(v, graph, color, c, V)) {

                color[v] = c;

                if (solve(graph, m, color, v + 1, V))
                    return true;

                color[v] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter number of colors:");
        int m = sc.nextInt();

        int[] color = new int[V];

        if (solve(graph, m, color, 0, V)) {
            System.out.println("Coloring is possible");
            System.out.println("Assigned colors:");

            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " -> Color " + color[i]);
            }
        } else {
            System.out.println("Coloring is not possible");
        }

        sc.close();
    }
}