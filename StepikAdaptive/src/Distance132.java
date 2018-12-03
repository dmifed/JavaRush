import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DIMA on 17.07.2018.
 */
public class Distance132 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        double distance = scanner.nextDouble();
        double hours = scanner.nextDouble();
        System.out.println(distance/hours);
    }
}
