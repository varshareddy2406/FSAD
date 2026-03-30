import java.util.*;

public class NaiveExample {

    static void search(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();
        boolean found = false;

        for (int i = 0; i <= n - m; i++) {

            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Pattern not found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String txt = sc.next();

        System.out.println("Enter pattern:");
        String pat = sc.next();

        search(txt, pat);

        sc.close();
    }
}