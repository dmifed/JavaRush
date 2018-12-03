import java.util.Scanner;

/**
 * Created by DIMA, on 31.07.2018
 */
public class Reversing112 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.next());
        scanner.close();
        System.out.println(sb.reverse().toString());

    }

}
