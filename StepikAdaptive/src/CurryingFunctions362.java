import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 20.07.2018
 */
public class CurryingFunctions362 {
    public static void main(String[] args) {

        Function<Integer, Function<Integer, Function<Integer, Integer>>> multyXYZ = x -> y -> z -> x + y*y + z*z*z;

        int aa = multyXYZ.apply(2).apply(3).apply(4);
        System.out.println(aa);


        Function<String, Function<String, Function<String, Function<String, String>>>> concateStrings =
                a -> b -> c -> d -> a.toLowerCase() + c.toUpperCase() + b.toLowerCase() + d.toUpperCase();

        String ss = concateStrings.apply("aa").apply("bb").apply("cc").apply("dd");
        System.out.println(ss);
        ss = concateStrings.apply("AAA").apply("bbb").apply("CCC").apply("ddd");
        System.out.println(ss);

    }
}
