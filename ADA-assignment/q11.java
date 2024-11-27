import java.util.Scanner;

public class q11 {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String uniqueString = removeDuplicates(input);
        System.out.println("String after duplicates removed: " + uniqueString);

        sc.close();
    }
}