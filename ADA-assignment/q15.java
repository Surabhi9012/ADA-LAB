import java.util.Scanner;

public class q15
 {
    public static int[] generateAllShifts(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] shifts = new int[n - m + 1];
        int count = 0;

        for (int i = 0; i <= n - m; i++) {
            if (text.substring(i, i + m).equals(pattern)) {
                shifts[count++] = i;
            }
        }

        int[] result = new int[count];
        System.arraycopy(shifts, 0, result, 0, count);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        int[] shifts = generateAllShifts(text, pattern);

        if (shifts.length == 0) {
            System.out.println("No matches found.");
        } else {
            System.out.println("All valid shifts:");
            for (int shift : shifts) {
                System.out.println(shift);
            }
        }
        scanner.close();
    }
}