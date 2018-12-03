import java.util.Scanner;

/**
 * Created by DIMA, on 28.08.2018
 */
public class Shape122 {
    public enum Shapes{
        square, circle, triangle, rhombus
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > Shapes.values().length || num < 1){
            System.out.println("There is no such shape!");
        }else {
            System.out.println("You have chosen a " + Shapes.values()[num-1]);
        }
    }
}
