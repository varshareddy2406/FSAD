import java.util.*;

public class InefficientFactorial {

    public static int inefficientFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * inefficientFactorial(n - 1) * inefficientFactorial(n - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n value: ");
        int n = sc.nextInt();

        int result = inefficientFactorial(n);
        System.out.println("Result: " + result);

        sc.close();
    }
}
