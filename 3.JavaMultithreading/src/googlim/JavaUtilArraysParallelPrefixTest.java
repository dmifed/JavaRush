package googlim;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

/**
 * Created by DIMA on 02.11.2017.
 */
public class JavaUtilArraysParallelPrefixTest {
    public static void main(String[] args) {
        double[] a = {11, 18, 4, 6}; // 11 29 33 39
        Arrays.parallelPrefix(a, 1, 3, new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left + right;
            }
        });
        for(double d : a){
            System.out.print(d + " ");
        }
    }

}
