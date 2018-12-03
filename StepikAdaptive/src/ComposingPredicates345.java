import java.util.List;
import java.util.function.IntPredicate;

/**
 * Created by DIMA, on 31.07.2018
 */
public class ComposingPredicates345 {
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = x -> false;

        for (IntPredicate intPred : predicates){
            intPredicate = intPredicate.or(intPred);
        }
        return intPredicate;
    }
}
