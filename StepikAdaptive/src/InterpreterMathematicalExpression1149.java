import java.util.Scanner;

/**
 * Created by DIMA, on 04.10.2018
 */
public class InterpreterMathematicalExpression1149 {

    enum Operations {
        plus, minus, multiply, divide
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String oper = scanner.next();
        Operations op = Operations.valueOf(oper);
        int b = scanner.nextInt();
        scanner.close();


        switch (op){
            case  plus:
                System.out.println(a+b);
                break;
            case minus:
                System.out.println(a-b);
                break;
            case multiply:
                System.out.println(a*b);
                break;
            case divide:
                System.out.println(Math.floorDiv(a ,b));
                break;
            default:
                System.out.println("Not support");
                break;
        }
    }
}
