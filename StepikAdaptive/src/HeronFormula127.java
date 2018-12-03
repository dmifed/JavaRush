import java.util.Scanner;

/**
 * Created by DIMA, on 22.08.2018
 */
public class HeronFormula127 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();
        double p = (a + b + c)/2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(s);

    }
}
