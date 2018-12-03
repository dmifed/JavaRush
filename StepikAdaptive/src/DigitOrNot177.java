import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIMA, on 31.07.2018
 */
public class DigitOrNot177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Pattern pattern = Pattern.compile("\\d");
        Matcher m = pattern.matcher(s);
        System.out.println(m.matches() ? "yes" : "no");
        scanner.close();
    }
}
