import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalsAlgorithm {

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        System.out.println("Enter number of edges:");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        System.out.println("Edges in MST:");

        int e = 0, i = 0;
        int totalCost = 0;

        while (e < V - 1 && i < E) {

            Edge next = edges[i++];

            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                System.out.println(next.src + " - " + next.dest + " : " + next.weight);
                totalCost += next.weight;
                union(subsets, x, y);
                e++;
            }
        }

        System.out.println("Total Cost of MST: " + totalCost);

        sc.close();
    }
}