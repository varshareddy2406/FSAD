import java.util.*;

public class SpecialStringSort {

    static String sortString(String s) {

        Map<Character, Integer> freq = new HashMap<>();

        // count frequency
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // store unique characters
        List<Character> chars = new ArrayList<>(freq.keySet());

        // sort by frequency, then lexicographically
        chars.sort((c1, c2) -> {
            int f1 = freq.get(c1);
            int f2 = freq.get(c2);

            if (f1 != f2)
                return f1 - f2;

            return c1 - c2;
        });

        // build result
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            for (int i = 0; i < freq.get(c); i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = sc.next();

        String result = sortString(s);

        System.out.println("Sorted string:");
        System.out.println(result);

        sc.close();
    }
}