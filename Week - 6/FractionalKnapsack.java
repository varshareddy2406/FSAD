import java.util.*;

public class FractionalKnapsack {

    static class Item {
        int weight, value;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of items:");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and value of items:");
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            items[i] = new Item(w, v);
        }

        System.out.println("Enter capacity of knapsack:");
        int cap = sc.nextInt();

        // Sort by value/weight ratio (descending)
        Arrays.sort(items, (a, b) ->
                Double.compare((double) b.value / b.weight,
                               (double) a.value / a.weight));

        double totalValue = 0;

        for (Item item : items) {

            if (cap >= item.weight) {
                cap -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) cap / item.weight);
                break;
            }
        }

        System.out.println("Maximum Value = " + totalValue);

        sc.close();
    }
}