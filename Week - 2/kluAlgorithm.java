import java.util.Scanner;

public class kluAlgorithm {
    public static void KLU(int n) {
        int count = 0;

        for (int i = 1; i < n; i = i * 2) {
            for (int j = n; j > 0; j = j / 3) {
                for (int k = 0; k < n; k++) {
                    count++;
                }
            }
        }

        System.out.println("Count value: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n value: ");
        int n = sc.nextInt();

        KLU(n);
        sc.close();
    }
}