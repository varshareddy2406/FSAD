import java.util.*;

public class JobSequencing {

    static class Job {
        char id;
        int deadline, profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of jobs:");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter job details (id deadline profit):");
        for (int i = 0; i < n; i++) {
            char id = sc.next().charAt(0);
            int d = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(id, d, p);
        }

        // Sort by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[n];
        char[] result = new char[n];

        int totalProfit = 0;

        for (Job j : jobs) {
            for (int i = Math.min(n, j.deadline) - 1; i >= 0; i--) {
                if (!slot[i]) {
                    slot[i] = true;
                    result[i] = j.id;
                    totalProfit += j.profit;
                    break;
                }
            }
        }

        System.out.println("Selected job sequence:");
        for (char c : result) {
            if (c != 0)
                System.out.print(c + " ");
        }

        System.out.println("\nTotal Profit = " + totalProfit);

        sc.close();
    }
}