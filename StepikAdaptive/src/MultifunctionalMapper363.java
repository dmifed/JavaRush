import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 09.10.2018
 */
public class MultifunctionalMapper363 {
    /**
     * The function accepts a list of mappers List<IntUnaryOperator> and returns an operator UnaryOperator<List<Integer>> that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */

    //List<IntUnaryOperator> - in
    //UnaryOperator<List<Integer>> - out equal Function<List<Integer>, List<Integer>>
    // neen to map IntUnaryOperator to UnaryOperator

    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
            listIntUnary -> listInt ->
                    listIntUnary.stream()
                            .reduce((u1, u2) -> u1.andThen(u2))
                            .map(u -> listInt.stream().map(i -> u.applyAsInt(i)))
                            .orElse(null).collect(Collectors.toList());



    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     *
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x*2, x -> x + 1));

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x*x, x -> x%2 == 0 ? x + 2 : x +1 ));

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(identityTransformation.apply(list));
        System.out.println(multTwoAndThenAddOneTransformation.apply(list));
        System.out.println(squareAndThenGetNextEvenNumberTransformation.apply(list));
    }
}
