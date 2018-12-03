import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DIMA on 18.07.2018.
 */
public class FizzBuzz142 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = start; i<=end; i++){
            if(i%3==0 && i%5 ==0){
                System.out.println("FizzBuzz");
            }else if(i%3 == 0){
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}
