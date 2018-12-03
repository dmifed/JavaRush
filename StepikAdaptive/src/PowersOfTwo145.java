import java.util.Scanner;

/**
 * Created by DIMA, on 24.08.2018
 */
public class PowersOfTwo145 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long limit  = scanner.nextLong();
        if (limit < 1){
            System.out.println(0);
        }else {
            long pow = 1;
            System.out.println(pow);
            while (pow*2 <= limit){
                pow *= 2;
                System.out.println(pow);
            }
        }
    }
}
