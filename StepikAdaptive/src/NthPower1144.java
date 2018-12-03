import java.util.Scanner;

/**
 * Created by DIMA, on 08.08.2018
 */
public class NthPower1144 {
    private static double calcPower(double a, int n){
        if(n == 0) return 1;
        if(a == 0 || a == 1) return a;
        if (n == 1) return a;
        else {
            //even n
            if(n%2 == 0){
                return calcPower(a*a, n/2);
            }else {
                return a * calcPower(a, n-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(calcPower(a,n));
    }
}
