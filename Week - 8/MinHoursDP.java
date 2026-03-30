import java.util.*;

public class MinHoursDP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of days:");
        int n = sc.nextInt();

        int[] hours = new int[n];

        System.out.println("Enter hours for each day:");
        for (int i = 0; i < n; i++) {
            hours[i] = sc.nextInt();
        }

        int[][] dp = new int[n][3];

        // Initialization
        dp[0][0] = hours[0]; // work today
        dp[0][1] = 0;        // rest 1 day
        dp[0][2] = 0;        // rest 2 days

        // DP transitions
        for (int i = 1; i < n; i++) {

            dp[i][0] = hours[i] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0];
            dp[i][2] = dp[i - 1][1];
        }

        int result = Math.min(dp[n - 1][0],
                     Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println("Minimum Hours = " + result);

        sc.close();
    }
}