import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int level;
    int profit;
    int weight;
    double bound;

    Node(int level, int profit, int weight, double bound) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.bound = bound;
    }
}

public class q16 {
    public static int knapsack_BestFS(int n, int[] p, int[] w, int W) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> -a.bound));
        Node v = new Node(0, 0, 0, bound(0, 0, w, p, W));
        pq.offer(v);
        int maxProfit = 0;

        while (!pq.isEmpty()) {
            v = pq.poll();
            if (v.bound > maxProfit) {
                Node u = new Node(v.level + 1, v.profit + p[v.level], v.weight + w[v.level], 0);
                if (u.weight <= W && u.profit > maxProfit) {
                    maxProfit = u.profit;
                }
                u.bound = bound(u.level, u.profit, w, p, W);
                if (u.bound > maxProfit) {
                    pq.offer(u);
                }
                u = new Node(v.level + 1, v.profit, v.weight, 0);
                u.bound = bound(u.level, u.profit, w, p, W);
                if (u.bound > maxProfit) {
                    pq.offer(u);
                }
            }
        }
        return maxProfit;
    }

    static double bound(int level, int profit, int[] w, int[] p, int W) {
        if (level * w[level] >= W) {
            return 0;
        } else {
            double bound = profit;
            int totalWeight = level * w[level];
            int j = level + 1;
            while (j < w.length && totalWeight + w[j] <= W) {
                totalWeight += w[j];
                bound += p[j];
                j++;
            }
            if (j < w.length) {
                bound += (W - totalWeight) * ((double) p[j] / w[j]);
            }
            return bound;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] w = new int[n];

        System.out.println("Enter the profits and weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Profit " + (i + 1) + ": ");
            p[i] = scanner.nextInt();
            System.out.print("Weight " + (i + 1) + ": ");
            w[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        int maxProfit = knapsack_BestFS(n, p, w, W);
        System.out.println("Maximum profit: " + maxProfit);

        scanner.close();
    }
}