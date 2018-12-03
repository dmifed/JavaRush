import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIMA, on 26.07.2018
 */
public class PhoneNumber1151 {
    private static boolean isPhoneNumber(String s){
        Pattern p = Pattern.compile("19\\d{9}");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if(isPhoneNumber(s)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
