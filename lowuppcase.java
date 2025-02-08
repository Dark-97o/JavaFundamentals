import java.util.Scanner;

public class lowuppcase {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Enyter a String:");
        String str =scanner.nextLine();
        System.out.println("Original string: " + str);
        String lowerStr = str.toLowerCase();
        System.out.println("String in lowercase: " + lowerStr);
        String upperStr = str.toUpperCase();
        System.out.println("String in uppercase: " + upperStr);
    }
}
