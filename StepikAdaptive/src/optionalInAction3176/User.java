package optionalInAction3176;

/**
 * Created by DIMA, on 05.10.2018
 */
public class User {
    private String login;
    private Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "login: " + login + " account: " + account;
    }
}
