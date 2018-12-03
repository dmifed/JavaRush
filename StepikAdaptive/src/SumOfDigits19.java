/**
 * Created by DIMA, on 10.08.2018
 */
public class SumOfDigits19 {
    private static int sumDigits(int number){
        int sumDigits = 0;
        while (number > 0){
            sumDigits += number%10;
            number = number / 10;
        }
        return sumDigits;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(new java.util.Scanner(System.in).nextInt()));
    }

}
