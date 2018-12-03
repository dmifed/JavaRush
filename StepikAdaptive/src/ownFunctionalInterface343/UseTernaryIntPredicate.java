package ownFunctionalInterface343;

import java.util.function.Predicate;

/**
 * Created by DIMA on 17.07.2018.
 */
public class UseTernaryIntPredicate {
    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> (a!=b && a!=c && b!=c);
    public static void main(String[] args) {
        boolean b = UseTernaryIntPredicate.allValuesAreDifferentPredicate.test(10,10,10);
        System.out.println(b);
        String s = 1+2 + " dfdf" + 1 + 2;
        System.out.println(s);
    }
}
