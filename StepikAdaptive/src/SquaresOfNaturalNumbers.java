import java.util.Scanner;

/**
 * Created by DIMA, on 28.08.2018
 */
public class SquaresOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int finalInteger = (int) Math.sqrt(num);
        for(int i = 1; i <= finalInteger ; i++){
            System.out.println(i*i);
        }
    }
}
