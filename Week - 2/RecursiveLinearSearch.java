import java.util.*;

public class RecursiveLinearSearch {

    // Recursive Linear Search method
    public static int recursiveLinearSearch(int[] a, int low, int high, int target) {

        if (low > high) {
            return -1; // base case: not found
        }

        if (a[low] == target) {
            return low; // element found
        }

        return recursiveLinearSearch(a, low + 1, high, target);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int result = recursiveLinearSearch(a, 0, n - 1, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");

        sc.close();
    }
}
