import java.util.Scanner;
public class test {
    public static void main(String[] args){
        int[] element  = {23,45,63,12,45};
        int sum=0;
        for(int number : element){
            sum=sum+number;
        }
        System.out.println("Sum of elements in the array:"+sum);
    }
    
}
