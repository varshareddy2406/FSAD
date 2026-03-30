import java.util.*;

public class KMPTime {

    // Compute LPS array
    static void computeLPS(String pat, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP Search
    static void KMPSearch(String txt, String pat) {

        int[] lps = new int[pat.length()];
        computeLPS(pat, lps);

        int i = 0, j = 0;
        boolean found = false;

        while (i < txt.length()) {

            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == pat.length()) {
                System.out.println("Pattern found at index: " + (i - j));
                found = true;
                j = lps[j - 1]; // continue searching
            } 
            else if (i < txt.length() && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
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

        long start = System.nanoTime();

        KMPSearch(txt, pat);

        long end = System.nanoTime();

        System.out.println("KMP Time: " + (end - start) + " ns");

        sc.close();
    }
}