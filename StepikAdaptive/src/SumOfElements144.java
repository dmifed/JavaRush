import java.util.Scanner;

/**
 * Created by DIMA, on 01.10.2018
 */
public class SumOfElements144 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int elem;
        while ((elem = scanner.nextInt()) != 0){
            sum += elem;
        }
        scanner.close();
        System.out.println(sum);
    }
}
