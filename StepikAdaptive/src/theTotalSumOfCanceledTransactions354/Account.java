package theTotalSumOfCanceledTransactions354;


import java.util.List;

/**
 * Created by DIMA on 06.07.2018.
 */
public class Account {
    private String number;
    private Long balance;
    private List<Transaction> transactions;

    public Account(String number, Long balance, List<Transaction> transactions) {
        this.number = number;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getNumber() {        return number;    }
    public Long getBalance() {        return balance;    }
    public List<Transaction> getTransactions() {        return transactions;    }
}
