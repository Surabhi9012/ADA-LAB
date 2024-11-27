import java.util.Scanner;

public class q19MColoring {
    static int n; // Number of vertices
    static int m; // Number of colors
    static int[][] W; // Adjacency matrix
    static int[] vcolor; // Array to store colors of vertices

    public static void m_coloring(int i) {
        if (isPromising(i)) {
            if (i == n) {
                // Print the color assignment for vertices
                for (int j = 1; j <= n; j++) {
                    System.out.print(vcolor[j] + " ");
                }
                System.out.println();
            } else {
                for (int color = 1; color <= m; color++) {
                    vcolor[i + 1] = color;
                    m_coloring(i + 1);
                }
            }
        }
    }

    public static boolean isPromising(int i) {
        int j = 1;
        boolean promising = true;

        while (j < i && promising) {
            if (W[i][j] == 1 && vcolor[i] == vcolor[j]) {
                promising = false;
            }
            j = j + 1;
        }
        return promising;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices (n): ");
        n = sc.nextInt();

        // Input number of colors
        System.out.print("Enter the number of colors (m): ");
        m = sc.nextInt();

        // Initialize adjacency matrix
        W = new int[n + 1][n + 1];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                W[i][j] = sc.nextInt();
            }
        }

        // Initialize vcolor array
        vcolor = new int[n + 1];

        System.out.println("Solutions:");
        m_coloring(0);
        sc.close();
    }
}
