import java.util.*;

public class CustomRecursiveFunction {

    public static int customRecursiveFunction(int n) {
        if (n <= 1) {
            return 1;
        }
        return 3 * customRecursiveFunction(n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n value: ");
        int n = sc.nextInt();

        int result = customRecursiveFunction(n);
        System.out.println("Result: " + result);

        sc.close();
    }
}
