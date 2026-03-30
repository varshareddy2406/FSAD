import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size:");
        int len = sc.nextInt();

        int[] arr = new int[len];

        System.out.println("Enter Array Elements:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter Key Value:");
        int key = sc.nextInt();

        int res = linearSearch(arr, key);

        if (res == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + res);

        sc.close();
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}