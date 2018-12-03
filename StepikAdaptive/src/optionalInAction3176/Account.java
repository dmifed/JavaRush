package optionalInAction3176;

import java.util.UUID;

/**
 * Created by DIMA, on 05.10.2018
 */
public class Account {
    private UUID quid;
    private long balance;

    public Account(UUID quid, long balance) {
        this.quid = quid;
        this.balance = balance;
    }

    public UUID getQuid() {
        return quid;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "quid: " + quid.getLeastSignificantBits() + "&" + quid.getMostSignificantBits() + " balance: " + balance;
    }
}
