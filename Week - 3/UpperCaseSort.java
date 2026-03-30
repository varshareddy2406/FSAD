import java.util.*;

public class UpperCaseSort {

    static int countUppercase(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of strings:");
        int n = sc.nextInt();

        String[] arr = new String[n];

        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        List<StringCount> list = new ArrayList<>();

        // pair each string with its uppercase count
        for (String s : arr) {
            list.add(new StringCount(s, countUppercase(s)));
        }

        // sort by uppercase count
        list.sort(Comparator.comparingInt(a -> a.count));

        // print output
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}

// helper class
class StringCount {
    String str;
    int count;

    StringCount(String str, int count) {
        this.str = str;
        this.count = count;
    }

    public String toString() {
        return "('" + str + "', " + count + ")";
    }
}