import java.util.Scanner;

/**
 * Created by DIMA, on 26.07.2018
 */
public class Snail13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int goUpDay = scanner.nextInt();
        int goDownDay = scanner.nextInt();

        int start = 0;
        int countDays = 0;

        while (true){
            start += goUpDay;
            if(start >= height){
                System.out.println(++countDays);
                break;
            }
            countDays++;
            start -= goDownDay;
        }



    }
}
