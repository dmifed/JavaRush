import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by DIMA on 18.07.2018.
 */
public class OneHundredYearsOld164 {
    public static void main(String[] args) {
        Calendar currentDate = new GregorianCalendar(2016, 11, 31);
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String name = scanner.next();
        int age = scanner.nextInt();
        int hundredYears = 100-age + currentDate.get(currentDate.YEAR);
        System.out.format("%s, You will be 100 years old in %d year." , name, hundredYears);


    }
}
