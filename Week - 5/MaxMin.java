import java.util.*;

public class MaxMin {

    static int[] findMaxMin(int[] a, int l, int r) {

        // Base case: one element
        if (l == r) {
            return new int[]{a[l], a[l]};
        }

        int mid = (l + r) / 2;

        int[] left = findMaxMin(a, l, mid);
        int[] right = findMaxMin(a, mid + 1, r);

        int max = Math.max(left[0], right[0]);
        int min = Math.min(left[1], right[1]);

        return new int[]{max, min};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] result = findMaxMin(a, 0, n - 1);

        System.out.println("Maximum = " + result[0]);
        System.out.println("Minimum = " + result[1]);

        sc.close();
    }
}