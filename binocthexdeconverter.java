import java.util.Scanner;

public class binocthexdeconverter {
    public static void dectobin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        String binary = Integer.toBinaryString(decimal);
        System.out.println("Binary representation: " + binary);
        sc.close();
    }
    public static void dectoct(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = sc.nextInt();
        String octal = Integer.toOctalString(decimal);
        System.out.println("Octal representation: " + octal);
        sc.close();
    }
    public static void hextodec(){
        Scanner sc = new Scanner(System.in);
        System.out .print("Enter a Hexadecimal number: ");
        String hex = sc.nextLine();
        int decimal = Integer.parseInt(hex, 16);
        System.out.println("Decimal equivalent: " + decimal);
    }
    public static void dectohex() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();
        System.out.println("Hexadecimal equivalent: " + hexadecimal);
    }
    public static void bintodec() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Decimal equivalent: " + decimal);
    }
    public static void octodec() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an octal number: ");
        String octal = scanner.nextLine();
        int decimal = Integer.parseInt(octal, 8);
        System.out.println("The decimal equivalent of octal " + octal + " is: " + decimal);
        scanner.close();
    }
    public static void main(String[] args){
        System.out.println("1.Decimal to Binary\n2.Decimal to Octal\n3.Hexadecimal to Decimal\n4.Decimal to Hexadecimal\n5.Binary to Decimal\n6.Octal to Decimal");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice==1){
            dectobin();
        }
        else if(choice==2){
            dectoct();
        }
        else if(choice==3){
            hextodec();
        }
        else if(choice==4){
            dectohex();
        }
        else if(choice==5){
            bintodec();
        }
        else if(choice==6){
            octodec();
        }
        else{
            System.out.println("Invalid Choice\nPlease Try Again");
        }

    }
}
