import java.util.*;

public class SortByFreq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements");
        int len = sc.nextInt();

        String arr[] = new String[len];

        System.out.println("Enter elements");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.next();
        }

        // Frequency map
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : arr) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        // Unique elements list
        List<String> list = new ArrayList<>(freqMap.keySet());

        // Sort by frequency, then lexicographically
        Collections.sort(list, (a, b) -> {
            int freqCompare = freqMap.get(a) - freqMap.get(b);
            if (freqCompare != 0)
                return freqCompare;
            return a.compareTo(b);
        });

        // Print elements according to frequency
        for (String s : list) {
            for (int i = 0; i < freqMap.get(s); i++) {
                System.out.print(s + " ");
            }
        }
    }
}
