import java.util.*;

public class SortHomework {

    static void sort(int[] a, int l, int r) {
        if (l >= r)
            return;

        int m = (l + r) / 2;

        sort(a, l, m);
        sort(a, m + 1, r);

        merge(a, l, m, r);
    }

    static void merge(int[] a, int l, int m, int r) {

        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= m)
            temp[k++] = a[i++];

        while (j <= r)
            temp[k++] = a[j++];

        for (i = 0; i < temp.length; i++) {
            a[l + i] = temp[i];
        }
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

        sort(a, 0, n - 1);

        System.out.println("Sorted array:");
        for (int x : a) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}