import java.util.Scanner;

/**
 * Created by DIMA, on 01.10.2018
 */
public class LeapYear115 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        scanner.close();
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            System.out.println("Leap");
        }else {
            System.out.println("Regular");
        }
    }
}
