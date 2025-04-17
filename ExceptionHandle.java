import java.sql.SQLOutput;
import java.util.Scanner;;

public class ExceptionHandle {
    void div(int a ,int b){
        System.out.println("Start_______");
        try {
            int c = a / b;
            System.out.println(c);
        }catch (Exception exception){
            System.out.println("Error due to divide by 0" + exception);
        }
        System.out.println("End_________");
    }

    void div(String a, String b){
        int i = 0 ,j = 0 ,k = 0;
        try {
            i = Integer.parseInt(a);
            j = Integer.parseInt(b);
            k = i/j;
        } catch (NumberFormatException numberFormatException){
            System.out.println("Invalid number");
        } catch (ArithmeticException arithmeticException){
            System.out.println("Error due to divide by 0.");
        } finally {
            System.out.println("Result : " + k);
        }

    }

    public static void main(String[] args) {
        ExceptionHandle obj = new ExceptionHandle();
        obj.div(50,5);
        obj.div(0,1);
        obj.div(50,0);
        obj.div(15,5);

        obj.div("100","5");
        obj.div("A","5");
        obj.div("5","B");
        obj.div("100","0");
        obj.div("AB","0");
        obj.div("0","A");

    }
}
