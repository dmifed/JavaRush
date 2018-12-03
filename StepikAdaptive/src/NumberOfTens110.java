import java.util.Scanner;

/**
 * Created by DIMA, on 27.07.2018
 */
public class NumberOfTens110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.next().split("");
        System.out.println(s.length > 1 ? s[s.length-2] : 0);
    }
}
