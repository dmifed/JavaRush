import java.util.Scanner;

/**
 * Created by DIMA, on 27.08.2018
 */
public class SumOfNumbers1142 {
    private static Scanner scanner = new Scanner(System.in);
    private static int sum = 0;
    public static void main(String[] args) {
        System.out.println(readAndSumrecursion(scanner.nextInt()));



    }
    private static long readAndSumrecursion(int num){
        sum += num;
        if(num == 0){
            scanner.close();
            return sum;
        }else {
            return readAndSumrecursion(scanner.nextInt());
        }
    }
}
