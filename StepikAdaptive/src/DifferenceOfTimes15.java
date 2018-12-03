import java.util.Scanner;

/**
 * Created by DIMA, on 01.08.2018
 */
public class DifferenceOfTimes15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours1 = scanner.nextInt();
        int minutes1 = scanner.nextInt();
        int seconds1 = scanner.nextInt();
        int hours2 = scanner.nextInt();
        int minutes2 = scanner.nextInt();
        int seconds2 = scanner.nextInt();
        int difTime = (hours2-hours1)*3600 + (minutes2-minutes1)*60 + seconds2 - seconds1;

        System.out.println(difTime);
    }
}
