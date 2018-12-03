/**
 * Created by DIMA, on 08.08.2018
 */
public class FindNumber1148 {
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number / 10 > 0) {
            sum += number % 10;
            number = number / 10;
        }
        sum += number%10;
        return sum;
    }

    private static int getCountNumbersWithEqualsSumOfDigits(int number){
        int count = 0;
        int sumExpected = sumOfDigits(number);
        for(int i = 1; i<number; i++){
            if(sumOfDigits(i) == sumExpected){
                ++count;
            }
        }
        return count;
    }




    public static void main(String[] args) {
        System.out.println(getCountNumbersWithEqualsSumOfDigits(new java.util.Scanner(System.in).nextInt()));
    }
}
