import java.util.Scanner;

/**
 * Created by DIMA, on 06.08.2018
 */
public class Triangle118 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();
        double cosA = (b*b + c*c - a*a)/(2*b*c);
        if(cosA > -1 && cosA < 1){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
