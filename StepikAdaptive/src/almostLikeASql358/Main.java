package almostLikeASql358;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.stream.Collectors.toList;

/**
 * Created by DIMA on 06.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        //Transaction(String uuid, Long sum, Account account)
        //Account(String number, Long balance)
        transactions.add(new Transaction("xxx1", 3L, new Account("Account 3", 154L)));
        transactions.add(new Transaction("xxx2", 7L, new Account("Account 3", 354L)));
        transactions.add(new Transaction("xxx3", -11L, new Account("Account 3", 444L)));
        transactions.add(new Transaction("xxx4", 13L, new Account("Account 3", 54L)));
        transactions.add(new Transaction("xxx5", 17L, new Account("Account 3", 15L)));

        Map<String, Long> totalSumOfTransByEachAccount = transactions.stream()
                .collect(Collectors.toMap(p -> p.getAccount().getNumber(), t -> t.getSum(), (sum1, sum2) -> sum1 + sum2));


        for(Map.Entry<String, Long> entry : totalSumOfTransByEachAccount.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }




}

