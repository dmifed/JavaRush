import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DIMA on 17.07.2018.
 */
public class SquirrelsAndNuts12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int squirrels = scanner.nextInt();
        int nuts = scanner.nextInt();

        System.out.println(nuts%squirrels);
    }
}
