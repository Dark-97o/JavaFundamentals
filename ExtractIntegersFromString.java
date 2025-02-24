import java.util.Scanner;

public class ExtractIntegersFromString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string containing alphabets and numbers: ");
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
            }
        }
        
        System.out.println("Extracted integers: " + result.toString());
        scanner.close();
    }
}
