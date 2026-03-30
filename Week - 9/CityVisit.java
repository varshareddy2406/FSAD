import java.util.*;

public class CityVisit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total number of cities:");
        int N = sc.nextInt();

        System.out.println("Enter number of already visited cities:");
        int m = sc.nextInt();

        int[] visited = new int[m];

        System.out.println("Enter visited cities:");
        for (int i = 0; i < m; i++) {
            visited[i] = sc.nextInt();
        }

        int remaining = N - m;

        int ways = 1;

        // factorial of remaining cities
        for (int i = 1; i <= remaining; i++) {
            ways *= i;
        }

        System.out.println("Ways to visit remaining cities = " + ways);

        sc.close();
    }
}