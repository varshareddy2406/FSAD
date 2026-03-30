import java.util.*;

public class CustomSort {

    static String order = "worldabcefghijkmnpqstuvxyz";
    static int[] rank = new int[26];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of words");
        int len = sc.nextInt();

        String[] words = new String[len];

        System.out.println("Enter words");
        for (int i = 0; i < len; i++) {
            words[i] = sc.next();
        }

        // Assign rank to each character
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Sort using custom comparator
        Arrays.sort(words, (a, b) -> compareWords(a, b));

        System.out.println("Sorted words:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    static int compareWords(String a, String b) {
        int minLen = Math.min(a.length(), b.length());

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return rank[a.charAt(i) - 'a'] - rank[b.charAt(i) - 'a'];
            }
        }
        return a.length() - b.length();
    }
}
