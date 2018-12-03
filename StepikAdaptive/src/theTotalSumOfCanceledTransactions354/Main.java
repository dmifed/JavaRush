package theTotalSumOfCanceledTransactions354;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DIMA on 06.07.2018.
 */
public class Main {
    public static void main(String[] args) {
        //Transaction(String uuid, State state, Long sum, Date create)
        Transaction transaction1 = new Transaction("100", State.PROCESSING, 100L, new Date(10000000));
        Transaction transaction2 = new Transaction("200", State.FINISHED, 250L, new Date(20000000));
        Transaction transaction3 = new Transaction("300", State.CANCELED, 310L, new Date(30000000));
        Transaction transaction4 = new Transaction("400", State.PROCESSING, 400L, new Date(40000000));
        Transaction transaction5 = new Transaction("500", State.FINISHED, 500L, new Date(50000000));
        Transaction transaction6 = new Transaction("600", State.CANCELED, 600L, new Date(60000000));
        Transaction transaction7 = new Transaction("700", State.PROCESSING, 700L, new Date(70000000));

        List<Transaction> transactionList01 = new ArrayList<>();
        transactionList01.add(transaction1);
        transactionList01.add(transaction2);
        transactionList01.add(transaction3);

        List<Transaction> transactionList02 = new ArrayList<>();
        transactionList02.add(transaction4);
        transactionList02.add(transaction5);
        transactionList02.add(transaction6);

        List<Transaction> transactionList03 = new ArrayList<>();
        transactionList03.add(transaction6);
        transactionList03.add(transaction7);
        //transactionList03.add(transaction1);

        //Account(String number, Long balance, List<Transaction> transactions)
        Account account1 = new Account("001", 1000L, transactionList01);
        Account account2 = new Account("002", 41000L, transactionList02);
        Account account3 = new Account("003", 0L, transactionList03);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(accountList));
    }


    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {

        return accounts.stream().filter(n -> n.getBalance() > 0)
                .flatMap(n -> n.getTransactions().stream()) //get stream of all transactions
                .filter(n -> n.getState() == State.CANCELED) //filter required transactions
                .mapToLong(n -> n.getSum()) // get sum of each transactions
                .reduce((s1, s2) -> s1 + s2).orElse(0); //summing

        // write your code here

    }
}
