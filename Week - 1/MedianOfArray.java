import java.util.*;

public class MedianOfArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length");
        int len = sc.nextInt();

        int arr[] = new int[len];

        System.out.println("Enter Array Elements");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        if (len % 2 != 0) {
            // Odd length → middle element
            System.out.println("Median = " + arr[len / 2]);
        } else {
            // Even length → average of two middle elements
            double median = (arr[len / 2] + arr[(len / 2) - 1]) / 2.0;
            System.out.println("Median = " + median);
        }
    }
}
