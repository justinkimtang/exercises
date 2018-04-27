import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class sum35{
    public static int sum(int end){
        int sum = 0;
        for(int i = 3; i< end; i+=3){
            sum+=i;
        }
        for(int i = 5; i< end; i+=5){
            sum+=i;
        }
        for(int i = 15; i< end; i+=15){
            sum-=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print("Input a number to count up to: ");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int max = in.nextInt();
        System.out.println("The sum up to " + max + " is " + sum(max));
        in.close();
    }
}