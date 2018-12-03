import java.util.Scanner;

/**
 * Created by DIMA, on 22.08.2018
 */
public class LargestElementOfSequence148 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int max = Integer.MIN_VALUE;
        while ((num = scanner.nextInt()) != 0){
            if (num > max){
                max = num;
            }
        }
        scanner.close();
        System.out.println(max);
    }
}
