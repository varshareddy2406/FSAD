import java.util.*;

public class MatrixChainMultiplicationRecursive {

    static int matrixChainOrder(int[] p, int i, int j) {

        if (i == j)
            return 0;

        int minCost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int cost = matrixChainOrder(p, i, k)
                    + matrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            if (cost < minCost)
                minCost = cost;
        }

        return minCost;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of matrices:");
        int n = sc.nextInt();

        // size array will be n+1
        int[] p = new int[n + 1];

        System.out.println("Enter dimensions array (size " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int result = matrixChainOrder(p, 1, n);

        System.out.println("Minimum number of multiplications: " + result);

        sc.close();
    }
}