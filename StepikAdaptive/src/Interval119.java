import java.util.Scanner;

/**
 * Created by DIMA, on 06.08.2018
 */
public class Interval119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        if((num>-15 && num <=12) || (num>14 && num<17) || num>=19){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
