import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DIMA on 17.07.2018.
 */
public class QuadraticEquation131 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double d = b*b - 4*a*c;
        System.out.println(d);
        if(d > 0){
            double x1 = (b*(-1) - Math.sqrt(d)) / (2*a);
            System.out.println(x1);
            double x2 = (b*(-1) + Math.sqrt(d)) / (2*a);
            System.out.println(x2);
            if(x1<x2){
                System.out.println(x1 + " " + x2);
            }else {
                System.out.println(x2 + " " + x1);
            }
        }else if(d == 0){
            double x = -b / (2*a);
            System.out.println(x);
        }
    }
}
