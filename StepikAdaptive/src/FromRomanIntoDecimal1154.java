import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 26.07.2018
 */
public class FromRomanIntoDecimal1154 {

    private static int number(String s){
        int num = 0;
        switch (s) {
            case "I" : num = 1; break;
            case "V" : num = 5; break;
            case "X" : num = 10; break;
            case "L" : num = 50; break;
            case "C" : num = 100; break;
            case "D" : num = 500; break;
            case "M" : num = 1000; break;
        }
        return num;
    }

    private static String[] getList(){
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.next().split("");
        scanner.close();
        return s;
    }

    private static int convert(String[] roman){
        int number = 0;
        int mayBeNeedNext = 0;
        for (int i = roman.length-1; i>=0; i--){
            int n = number(roman[i]);
            if(i != 0){
                mayBeNeedNext = number(roman[i-1]);
                if (mayBeNeedNext < n){
                    n -= mayBeNeedNext;
                    i--;
                }
            }
            number += n;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(convert(getList()));
    }
}
