import java.util.Scanner;

/**
 * Created by DIMA, on 28.08.2018
 */
public class NextEvenNumber18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();
        System.out.println(x + 2 - x % 2);
    }
}
