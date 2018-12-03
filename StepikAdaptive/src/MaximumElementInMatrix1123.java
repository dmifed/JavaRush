import java.util.Scanner;

/**
 * Created by DIMA, on 14.08.2018
 */
public class MaximumElementInMatrix1123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int maxRow = 0;
        int maxColumn = 0;
        int max = Integer.MIN_VALUE;
        for(int row = 0; row < rows; row++){
            for (int column = 0; column < columns; column++){
                int testElem = scanner.nextInt();
                if(testElem > max){
                    max = testElem;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }
        scanner.close();
        System.out.printf("%d %d", maxRow, maxColumn);
    }
}
