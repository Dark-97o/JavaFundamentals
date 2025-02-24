import java.util.Scanner;

public class ExtractIntegersFromString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string containing alphabets and numbers: ");
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int sum=0;
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
                sum+=Character.getNumericValue(ch);
            }
        }
        System.out.println("Extracted integers: " + result);
        System.out.println("Sum of extracted integers: " + sum);
        System.out.print("Enter a divisor: ");
        int divisor = scanner.nextInt();
        System.out.println("Sum divided by " + divisor + " is: " + sum/divisor);
        scanner.close();
    }
}