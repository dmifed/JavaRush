package linearEquationsSolver;

import java.util.Scanner;

/**
 * Created by DIMA, on 29.11.2018
 * ax + by = c
 * dx + ey = f
 */
public class SystemWithTwoVariables {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        sc.close();


        double y = (f * a - d * c) / (e * a - d * b);
        double x = (c - b * y) / a;

        System.out.println(x + " " + y);


    }



}
