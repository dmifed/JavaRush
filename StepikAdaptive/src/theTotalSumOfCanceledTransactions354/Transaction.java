package theTotalSumOfCanceledTransactions354;

import java.util.Date;

/**
 * Created by DIMA on 06.07.2018.
 */
public class Transaction {
    private String uuid;
    private State state;
    private Long sum;
    private Date create;

    public Transaction(String uuid, State state, Long sum, Date create) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.create = create;
    }

    public String getUuid() {        return uuid;    }
    public State getState() {        return state;    }
    public Long getSum() {        return sum;    }
    public Date getCreate() {        return create;    }
}
