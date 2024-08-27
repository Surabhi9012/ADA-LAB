import java.util.Scanner;

public class LongestCommonSubsequence {
    // Divide and Conquer approach
    public static int lcsLengthDC(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcsLengthDC(X, Y, m - 1, n - 1);
        else
            return Math.max(lcsLengthDC(X, Y, m, n - 1), lcsLengthDC(X, Y, m - 1, n));
    }

    // Dynamic Programming approach
    public static int lcsLengthDP(String X, String Y) {
        int m = X.length();
        int n = Y.length(); 
        int[][] C = new int[m + 1][n + 1];
        String[][] b = new String[m + 1][n + 1];

        // Initialize first row and column
        for (int i = 0; i <= m; i++)
            C[i][0] = 0;
        for (int j = 0; j <= n; j++)
            C[0][j] = 0;

        // Fill C[][] and b[][]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    b[i][j] = "↖";
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    b[i][j] = "↑";
                } else {
                    C[i][j] = C[i][j - 1];
                    b[i][j] = "←";
                }
            }
        }

        // Print the LCS using b array
        System.out.println("Longest Common Subsequence (using b array):");
        printLCS(b, X, m, n);
        System.out.println();

        // Print the LCS without using b array
        System.out.println("Longest Common Subsequence (without using b array):");
        printLCSWithoutB(C, X, Y, m, n);
        System.out.println();

        return C[m][n];
    }

    // Helper method to print the LCS using b array
    private static void printLCS(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j].equals("↖")) {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (b[i][j].equals("↑")) {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }

    // Helper method to print the LCS without using b array
    private static void printLCSWithoutB(int[][] C, String X, String Y, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            printLCSWithoutB(C, X, Y, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (C[i - 1][j] > C[i][j - 1]) {
            printLCSWithoutB(C, X, Y, i - 1, j);
        } else {
            printLCSWithoutB(C, X, Y, i, j - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string (X): ");
        String X = scanner.nextLine();

        System.out.print("Enter the second string (Y): ");
        String Y = scanner.nextLine();

        System.out.println("String X: " + X);
        System.out.println("String Y: " + Y);

        int lcsLengthDC = lcsLengthDC(X, Y, X.length(), Y.length());
        System.out.println("Length of LCS (Divide and Conquer): " + lcsLengthDC);

        // Dynamic Programming approach
        int lcsLengthDP = lcsLengthDP(X, Y);
        System.out.println("Length of LCS (Dynamic Programming): " + lcsLengthDP);

        scanner.close();
    }
}