import java.util.Scanner;

/**
 * Created by DIMA, on 10.08.2018
 */
public class FractionalPart128 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.next().split("\\D");
        if(strings.length < 2){
            System.out.println("0.0");
        }else {
            System.out.println(0 + "." + strings[1]);
        }

        scanner.close();
    }
}
