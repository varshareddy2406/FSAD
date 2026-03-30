import java.util.*;

public class MaxSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = nums[0];
        int current = nums[0];

        for (int i = 1; i < n; i++) {

            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }

        System.out.println("Maximum Subarray Sum = " + max);

        sc.close();
    }
}