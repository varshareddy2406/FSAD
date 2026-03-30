import java.util.*;

public class NaiveSearch {

    static int findPattern(char[] txt, char[] pat) {

        int n = txt.length;
        int m = pat.length;

        for (int i = 0; i <= n - m; i++) {

            int j;
            for (j = 0; j < m; j++) {
                if (txt[i + j] != pat[j]) {
                    break;
                }
            }

            if (j == m) {
                return i;   // pattern found
            }
        }

        return -1;   // not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String txt = sc.nextLine();   // supports spaces

        System.out.println("Enter pattern:");
        String pattern = sc.nextLine();

        int index = findPattern(txt.toCharArray(), pattern.toCharArray());

        if (index != -1)
            System.out.println("Pattern found at index " + index);
        else
            System.out.println("Pattern not found");

        sc.close();
    }
}