import java.util.*;

public class TSP {

    static int tsp(int mask, int pos, int[][] dist, int[][] dp, int n) {

        // All cities visited → return to source
        if (mask == (1 << n) - 1)
            return dist[pos][0];

        if (dp[mask][pos] != -1)
            return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {

            // If city not visited
            if ((mask & (1 << city)) == 0) {

                int newAns = dist[pos][city] +
                        tsp(mask | (1 << city), city, dist, dp, n);

                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of cities:");
        int n = sc.nextInt();

        int[][] dist = new int[n][n];

        System.out.println("Enter distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[1 << n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int result = tsp(1, 0, dist, dp, n);

        System.out.println("Minimum Distance = " + result);

        sc.close();
    }
}