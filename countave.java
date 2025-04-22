import java.util.*;

public class countave{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i=0; i < arr.length; i++){
            System.out.print("Enter a number:");
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int num : arr){
            sum = sum + num;
        }
        double avrg = sum / 10;
        System.out.println("Average is: "+ avrg);
        int count = 0;
        for (int num : arr){
            if (num > avrg){
                count++;
            }
        }
        if (count == 0){
            System.out.println("All numbers are less than average.");
        } else {
            System.out.println(count +" numbers are greater than average");
        }
        sc.close();
    }
}