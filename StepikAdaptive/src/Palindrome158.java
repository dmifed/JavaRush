import java.util.Scanner;

/**
 * Created by DIMA, on 31.07.2018
 */
public class Palindrome158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        System.out.println(s2.equals(s1) ? "yes" : "no");
        scanner.close();
    }
}
