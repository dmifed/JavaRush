package linearEquationsSolver;

import java.util.Scanner;

/**
 * Created by DIMA, on 28.11.2018
 *
 * Write a program that solves the equation a * x = b.
 * Numbers a and b should be read from the first line of the standard input.
 * You should output the value x, which turns the equation to be true.
 * For example, if the input contains numbers 5 and 3, this means that you should interpret this as equation 5 * x = 3.
 * For this example, the answer would be 0.6 since 5 * 0.6 = 3.
 */
public class SimpleEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double multiFactorX = sc.nextDouble();
        double result = sc.nextDouble();
        sc.close();
        double calculatedX;
        if(multiFactorX == 0){
            calculatedX = result > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }else if(result == 0){
            calculatedX = 0;
        }else {
            calculatedX = result / multiFactorX;
        }
        System.out.println(calculatedX);
    }
}
