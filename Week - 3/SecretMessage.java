import java.util.*;

public class SecretMessage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the encoded string:");
        String s = sc.next();

        String result = encode(s);

        System.out.println("Decoded string:");
        System.out.println(result);

        sc.close();
    }

    static String encode(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i += 2) {
            char ch = s.charAt(i);
            int shiftBy = s.charAt(i + 1) - '0';

            result.append(ch);
            result.append((char)(ch + shiftBy));
        }

        // if odd length, add last character
        if (s.length() % 2 != 0) {
            result.append(s.charAt(s.length() - 1));
        }

        return result.toString();
    }
}