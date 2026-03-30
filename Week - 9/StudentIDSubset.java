import java.util.*;

public class StudentIDSubset {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of IDs:");
        int n = sc.nextInt();

        String[] ids = new String[n];

        System.out.println("Enter IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.next();
        }

        int count = 0;

        // Generate all subarrays
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                String subset = "";

                for (int k = i; k <= j; k++) {
                    subset += ids[k];
                }

                // Check condition
                if (subset.contains("3") && subset.contains("1")) {
                    count++;
                }
            }
        }

        System.out.println("Total Valid Subsets = " + count);

        sc.close();
    }
}