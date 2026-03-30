import java.util.*;

public class RabinKarp {

    static void search(int[] txt, int[] pat, int q) {

        int d = 10; // base
        int n = txt.length;
        int m = pat.length;

        int h = 1;
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        int p = 0, t = 0;

        // initial hash values
        for (int i = 0; i < m; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + txt[i]) % q;
        }

        boolean found = false;

        for (int i = 0; i <= n - m; i++) {

            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (txt[i + j] != pat[j])
                        break;
                }

                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                    found = true;
                }
            }

            // calculate next window hash
            if (i < n - m) {
                t = (d * (t - txt[i] * h) + txt[i + m]) % q;

                if (t < 0)
                    t += q;
            }
        }

        if (!found) {
            System.out.println("Pattern not found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of text array:");
        int n = sc.nextInt();
        int[] txt = new int[n];

        System.out.println("Enter text elements:");
        for (int i = 0; i < n; i++) {
            txt[i] = sc.nextInt();
        }

        System.out.println("Enter size of pattern array:");
        int m = sc.nextInt();
        int[] pat = new int[m];

        System.out.println("Enter pattern elements:");
        for (int i = 0; i < m; i++) {
            pat[i] = sc.nextInt();
        }

        System.out.println("Enter prime number (q):");
        int q = sc.nextInt();

        search(txt, pat, q);

        sc.close();
    }
}