import java.util.Scanner;

/**
 * Created by DIMA, on 26.07.2018
 */
public class FibonacciNumber1157 {
    private static int fibonacci(int x){
        int fib0 = 0;
        int fib1 = 1;
        int fib = 0;
        if (x == 0) return fib0;
        if (x == 1) return fib1;

        for (int i = 2; i <= x; i++){
            fib = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fibonacci(scanner.nextInt()));
    }
}
