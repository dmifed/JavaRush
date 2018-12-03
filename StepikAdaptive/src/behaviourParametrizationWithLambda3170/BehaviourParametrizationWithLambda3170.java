package behaviourParametrizationWithLambda3170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 03.10.2018
 */
public class BehaviourParametrizationWithLambda3170 {

    public static void main(String[] args) {
        Account a1 = new Account("a1", 100, false);
        Account a2 = new Account("a2", 0, false);
        Account a3 = new Account("a3", -1, false);
        Account a4 = new Account("a4", 100, true);
        Account a5 = new Account("a5", -1, true);
        Account a6 = new Account("a6", 100_000_001, false);
        Account a7 = new Account("a7", 200_000_000, true);
        Account a8 = new Account("a8", 300_000_000, false);
        List<Account> accountList = new ArrayList<>(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8));
        Predicate<Account> accountPredicateNonEmpty = x -> x.getBalance() > 0;
        Predicate<Account> accountPredicateNonLockedAndMuchMoney = x -> !x.isLocked() && x.getBalance() >= 100_000_000;

        List<Account> nonEmptyAccounts = filter(accountList, x -> x.getBalance() > 0);
        List<Account> accountsWithTooMuchMoney = filter(accountList, x -> !x.isLocked() && x.getBalance() >= 100_000_000);
        System.out.println(nonEmptyAccounts);
        System.out.println(accountsWithTooMuchMoney);
    }

    static <T> List<T> filter(List<T> elems, Predicate<T> predicate){
        return elems.stream().filter(predicate).collect(Collectors.toList());
    }

}
