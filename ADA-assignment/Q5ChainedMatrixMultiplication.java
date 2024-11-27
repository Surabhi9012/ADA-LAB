import java.util.Scanner;

public class Q5ChainedMatrixMultiplication {

    public static int minMul(int[] d, int[][] P, int n) {
        int[][] M = new int[n][n];

        // Initialize diagonal elements to 0
        for (int i = 1; i < n; i++) {
            M[i][i] = 0;
        }

        // Fill the matrix
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                M[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (cost < M[i][j]) {
                        M[i][j] = cost;
                        P[i][j] = k;
                    }
                }
            }
        }

        return M[1][n - 1];
    }

    public static void printOptimalParenthesization(int[][] P, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(P, i, P[i][j]);
            printOptimalParenthesization(P, P[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for matrix dimensions
        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        int[] dimensions = new int[numMatrices + 1];
        System.out.println("Enter the dimensions of matrices:");

        for (int i = 0; i <= numMatrices; i++) {
            System.out.print("Dimension " + (i + 1) + ": ");
            dimensions[i] = scanner.nextInt();
        }

        int n = dimensions.length;
        int[][] P = new int[n][n];

        // Calculate minimum multiplications and print results
        int result = minMul(dimensions, P, n);
        System.out.println("Minimum number of multiplications: " + result);

        System.out.print("Optimal parenthesization: ");
        printOptimalParenthesization(P, 1, n - 1);
        System.out.println();
    }
}
