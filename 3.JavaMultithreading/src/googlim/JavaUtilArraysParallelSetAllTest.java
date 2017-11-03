package googlim;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

/**
 * Created by DIMA on 02.11.2017.
 */
public class JavaUtilArraysParallelSetAllTest {
    public static void main(String[] args) {
        double[] a = {11, 18, 4, 6, 10};
        Arrays.parallelSetAll(a, new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return value;
            }
        });


        for(double d : a){            System.out.print(d + " ");        }
    }
}
