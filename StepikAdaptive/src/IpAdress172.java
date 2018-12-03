import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DIMA, on 03.08.2018
 */
public class IpAdress172 {
    public static void main(String[] args) {
        boolean isIp = true;
        Scanner scanner = new Scanner(System.in);
        String ipString = scanner.next();
        scanner.close();
        Pattern pattern = Pattern.compile(".*\\D+$");
        Matcher matcher = pattern.matcher(ipString);
        if(matcher.matches()){
            isIp = false;
        }
        String[] ip = ipString.split("\\.");
        if(ip.length != 4 && isIp) {
            isIp = false;
        }else {
            for(String s : ip){
                int i;
                try{
                    i = Integer.parseInt(s);
                }catch (NumberFormatException e){
                    isIp = false;
                    break;
                }
                if(i<0 || i > 255){
                    isIp = false;
                    break;
                }
            }
        }
        System.out.println(isIp ? "YES" : "NO");
    }
}
