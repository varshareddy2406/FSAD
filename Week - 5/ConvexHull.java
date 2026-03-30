import java.util.*;

class ConvexHull {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Find side of point p w.r.t line ab
    static int side(Point a, Point b, Point p) {
        return Integer.compare((b.x - a.x) * (p.y - a.y) - (b.y - a.y) * (p.x - a.x), 0);
    }

    // Distance from line ab
    static int distance(Point a, Point b, Point p) {
        return Math.abs((b.x - a.x) * (p.y - a.y) - (b.y - a.y) * (p.x - a.x));
    }

    // QuickHull recursive function
    static void quickHull(Point[] points, Point a, Point b, int side, Set<Point> result) {

        int index = -1;
        int maxDist = 0;

        for (int i = 0; i < points.length; i++) {
            int dist = distance(a, b, points[i]);

            if (side(a, b, points[i]) == side && dist > maxDist) {
                index = i;
                maxDist = dist;
            }
        }

        if (index == -1) {
            result.add(a);
            result.add(b);
            return;
        }

        quickHull(points, points[index], a, -side(points[index], a, b), result);
        quickHull(points, points[index], b, -side(points[index], b, a), result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of points:");
        int n = sc.nextInt();

        Point[] points = new Point[n];

        System.out.println("Enter x and y coordinates:");
        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        // Find leftmost and rightmost points
        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (points[i].x < points[left].x)
                left = i;
            if (points[i].x > points[right].x)
                right = i;
        }

        Set<Point> result = new LinkedHashSet<>();

        quickHull(points, points[left], points[right], 1, result);
        quickHull(points, points[left], points[right], -1, result);

        System.out.println("Convex Hull Points:");
        for (Point p : result) {
            System.out.print(p + " ");
        }

        sc.close();
    }
}