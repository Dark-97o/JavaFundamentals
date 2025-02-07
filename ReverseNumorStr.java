import java.util.Scanner;

public class ReverseNumber {
    public static void reverstr(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed string: " + reversed);
        scanner.close();
    }
        
    public static void reverynum(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println("Reversed number: " + reversed);
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Reverse a String \n2. Reverse a Number");
        System.out.print("Enter your choice: ");
        int ch = scanner.nextInt();
        if(ch==1){
            reverstr();
        }
        else if(ch==2){
            reverynum();
        }
    }
}
