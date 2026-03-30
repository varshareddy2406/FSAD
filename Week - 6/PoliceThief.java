import java.util.*;

public class PoliceThief {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        char[] arr = new char[n];

        System.out.println("Enter elements (P for Police, T for Thief):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        System.out.println("Enter maximum distance k:");
        int k = sc.nextInt();

        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();

        // Store positions
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                police.add(i);
            else if (arr[i] == 'T')
                thief.add(i);
        }

        int i = 0, j = 0, count = 0;

        // Two-pointer technique
        while (i < police.size() && j < thief.size()) {

            if (Math.abs(police.get(i) - thief.get(j)) <= k) {
                count++;
                i++;
                j++;
            }
            else if (police.get(i) < thief.get(j)) {
                i++;
            }
            else {
                j++;
            }
        }

        System.out.println("Maximum thieves caught = " + count);

        sc.close();
    }
}