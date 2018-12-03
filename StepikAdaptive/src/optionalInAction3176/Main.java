package optionalInAction3176;

import java.util.*;


/**
 * Created by DIMA, on 05.10.2018
 */
public class Main {
    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return Optional.ofNullable(users.stream().filter(p -> p.getLogin().equals(login)).findFirst().orElse(null));
    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin)
                .filter(p -> p.getAccount() != null && p.getAccount().getBalance() >0)
                .map(p -> p.getAccount().getBalance())
                .map(p -> userLogin + ": " + p)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        User u1 = new User("1", new Account(new UUID(100, 100), 100));
        User u2 = new User("2", new Account(new UUID(200, 200), 200));
        User u3 = null;
        User u4 = new User("3", null);
        User u5 = new User("5", new Account(new UUID(500,500), 0));

        users.add(u1);
        users.add(u2);
        //users.add(u3);
        users.add(u4);
        users.add(u5);

        //System.out.println(findUserByLogin("5"));
        //System.out.println(findUserByLogin("6"));
        printBalanceIfNotEmpty("3");
        printBalanceIfNotEmpty("4");
        printBalanceIfNotEmpty("2");
        printBalanceIfNotEmpty("1");


    }


}
