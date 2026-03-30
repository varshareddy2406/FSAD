import java.util.*;

public class Strassen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of Matrix A (2x2):");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println("Enter elements of Matrix B (2x2):");
        int e = sc.nextInt();
        int f = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();

        // Strassen formulas
        int p1 = a * (f - h);
        int p2 = (a + b) * h;
        int p3 = (c + d) * e;
        int p4 = d * (g - e);
        int p5 = (a + d) * (e + h);
        int p6 = (b - d) * (g + h);
        int p7 = (a - c) * (e + f);

        int c11 = p5 + p4 - p2 + p6;
        int c12 = p1 + p2;
        int c21 = p3 + p4;
        int c22 = p5 + p1 - p3 - p7;

        System.out.println("Resultant Matrix:");
        System.out.println(c11 + " " + c12);
        System.out.println(c21 + " " + c22);

        sc.close();
    }
}