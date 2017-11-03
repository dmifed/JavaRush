package googlim;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by DIMA on 01.11.2017.
 */
public class JavaUtilArraysAsListTest {

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("A", "B", "C");
        for(String item : lst){       System.out.print(item + " ");      }
        System.out.println();
        lst.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if(s.equals("B")){
                    return "D";
                }
                return s;
            }
        });
        for(String item : lst){       System.out.print(item + " ");      }
        System.out.println();
    }
}
