package Lab1;

import java.util.Scanner;

public class Factorial {

    static long factorial(long num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();

        long factorial = factorial(num);
        System.out.println("The factorial of "+num+" is "+factorial);

    }

}
