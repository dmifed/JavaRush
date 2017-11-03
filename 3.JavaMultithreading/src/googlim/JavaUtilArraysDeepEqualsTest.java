package googlim;

import java.util.Arrays;

/**
 * Created by DIMA on 02.11.2017.
 */
public class JavaUtilArraysDeepEqualsTest {
    public static void main(String[] args) {
        String[] a1 = {"A", "B", "C"};
        String[] a2 = {"D", "E", "F"};
        String[] a3 = {"A", "B", "C"};
        String[] a4 = {"D", "E", "F"};

        Object[] b1 = {a1, a2};
        Object[] b2 = {a3, a4};

        System.out.println(Arrays.deepEquals(b1, b2));
        System.out.println(Arrays.equals(b1, b2));
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.deepToString(b1));
    }



}
