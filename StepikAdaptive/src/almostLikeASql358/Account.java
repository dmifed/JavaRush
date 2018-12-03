package almostLikeASql358;

/**
 * Created by DIMA on 06.06.2018.
 */
public class Account {
    private String number;
    private Long balance;

    public Account(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }
}
