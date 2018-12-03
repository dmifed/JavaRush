import java.util.Scanner;

/**
 * Created by DIMA, on 25.07.2018
 */
public class UppercaseOnlyLatin176 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(s.matches("[a-z]")){
            System.out.println(s.toUpperCase());
        }else if(s.matches("[A-Z]")){
            System.out.println(s.toLowerCase());
        }else {
            System.out.println(s);
        }
    }
}
