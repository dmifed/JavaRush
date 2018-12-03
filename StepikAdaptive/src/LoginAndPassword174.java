import java.util.Scanner;

/**
 * Created by DIMA, on 01.08.2018
 */
public class LoginAndPassword174 {
    public static void main(String[] args) {
        int login = 100500;
        int password = 424242;
        Scanner scanner = new Scanner(System.in);
        LoginAndPassword174 loginAndPassword174 = new LoginAndPassword174();
        User testUser = loginAndPassword174.new User(scanner.nextInt(), scanner.nextInt());
        User originalUser = loginAndPassword174.new User(login, password);
        if(testUser.login == originalUser.login && testUser.pass == originalUser.pass){
            System.out.println("Login success");
        }else if(testUser.login == originalUser.login){
            System.out.println("Wrong password");
        }else {
            System.out.printf("No user with login %d found", testUser.login);
        }



    }
    private class User{
        private int login;
        private int pass;

        public User(int login, int pass) {
            this.login = login;
            this.pass = pass;
        }

        public int getLogin() {
            return login;
        }

        public int getPass() {
            return pass;
        }
    }
}
