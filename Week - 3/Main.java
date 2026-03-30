import java.util.*;

public class Main {

    static void oddEvenMergeSort(String[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            oddEvenMergeSort(arr, low, mid);
            oddEvenMergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);  // FIXED
        }
    }

    static void merge(String[] arr, int low, int mid, int high) {

        int i = low, j = mid + 1;
        ArrayList<String> temp = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }

        while (i <= mid) temp.add(arr[i++]);
        while (j <= high) temp.add(arr[j++]);

        for (int k = 0; k < temp.size(); k++) {
            arr[low + k] = temp.get(k);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of names:");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        oddEvenMergeSort(names, 0, n - 1);

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.print(name + " ");
        }

        sc.close();
    }
}