import java.util.Scanner;

/**
 * Created by DIMA, on 25.07.2018
 */
public class DigitalWatches16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secondsPassed = scanner.nextInt();
        int timeInSeconds = secondsPassed%(60*60*24);
        int hours = timeInSeconds/(60*60);
        int minutes = (timeInSeconds - hours*60*60)/60;
        int seconds = timeInSeconds - hours*60*60 - minutes*60;
        System.out.printf("%d:%02d:%02d" , hours, minutes, seconds);

    }
}
