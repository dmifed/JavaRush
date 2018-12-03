import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DIMA on 16.07.2018.
 */
public class RotateRectangleArray1129 {
    private int[][] getArray(){
        boolean hasGetted = true;
        int row;
        int column;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        row = scanner.nextInt();
        column = scanner.nextInt();
        int[][] arr = new int[row][column];
        for (int i = 0; i<row; i++){
            if (!scanner.hasNext()){
                break;
            }
            for (int j = 0; j<column; j++){
                if(scanner.hasNext()){
                    arr[i][j] = scanner.nextInt();
                }else {
                    System.out.println("scanner nas not next at row = " + i + ", column = " + j);
                    hasGetted = false;
                    break;
                }
            }
        }
        if(hasGetted){
            return arr;
        }else {
            System.out.println("failed to get array");
            return new int[row][column];
        }
    }

    private void printArray(int[][] array){
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[i].length; j++){
                if(j != array[i].length-1){
                    System.out.print(array[i][j] + " ");
                }else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }

    private int[][] rotate90DegreesClockWise(int[][] array){
        int newRow = array[0].length;
        int newCol = array.length;
        int[][] rotatedarray = new int[newRow][newCol];
        for (int i = newRow-1; i>=0; i--){
            for (int j = 0; j<newCol; j++){
                rotatedarray[i][newCol - j -1] = array[j][i];
            }
        }
        return rotatedarray;
    }

    public static void main(String[] args) {
        RotateRectangleArray1129 r = new RotateRectangleArray1129();
        int[][] a = r.getArray();
        r.printArray(r.rotate90DegreesClockWise(a));
    }

}
