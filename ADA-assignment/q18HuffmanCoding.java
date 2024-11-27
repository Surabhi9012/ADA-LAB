import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    char symbol;
    int frequency;
    Node left, right;

    Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class q18HuffmanCoding {
    public static void huffman(char[] symb, int[] freq, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(new Node(symb[i], freq[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        Node root = pq.poll();
        printCodes(root, "");
    }

    private static void printCodes(Node root, String str) {
        if (root.left == null && root.right == null) {
            System.out.println(root.symbol + ": " + str);
            return;
        }
        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of symbols: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        char[] symb = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter the symbols and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Symbol " + (i + 1) + ": ");
            symb[i] = scanner.next().charAt(0);

            System.out.print("Frequency for " + symb[i] + ": ");
            freq[i] = scanner.nextInt();
        }

        huffman(symb, freq, n);

        scanner.close();
    }
}
