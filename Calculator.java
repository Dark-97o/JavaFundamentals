package Lab1;

public class Calculator {
    static void addition(int num1 ,int num2){
        int sum = num1 + num2;
        System.out.println("The addition is : "+sum);

    }
    static void subtraction(int num1 , int num2){
        int sub ;
        if(num1>=num2){
            sub = num1-num2;
        }
        else{
            sub =num2 - num1;
        }
        System.out.println("The subtraction is : "+sub);
    }
    static void multiplication(int num1 ,int num2){
        int multi = num1*num2;
        System.out.println("The multiplication is : "+multi);
    }
    static void division(int num1 ,int num2){
        int division = num1/num2;
        System.out.println("The division of the number is : "+division);
    }

    public static void main(String[] args) {
        addition(10,5);
        subtraction(10,4);
        multiplication(3,5);
        division(100,10);
    }


}
