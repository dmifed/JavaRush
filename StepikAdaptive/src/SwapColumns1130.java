import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 27.07.2018
 */
public class SwapColumns1130 {
    private ReadData getData(){
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] ints = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                ints[i][j] = scanner.nextInt();
            }
        }
        int columnI = scanner.nextInt();
        int columnJ = scanner.nextInt();
        scanner.close();
        ReadData rd = new ReadData(ints, columnI,columnJ);
        return rd;
    }

    private class ReadData{
        private int[][] ints;
        private int columnI;
        private int columnJ;

        private ReadData(int[][] ints, int columnI, int columnJ) {
            this.ints = ints;
            this.columnI = columnI;
            this.columnJ = columnJ;
        }
    }

    private int[][] swapColumns(int[][] arr, int columnI, int columnJ){
        for (int i = 0; i< arr.length; i++){
            int tmp = arr[i][columnI];
            arr[i][columnI] = arr[i][columnJ];
            arr[i][columnJ] = tmp;
        }
        return arr;
    }
    private void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[i].length; j++){
                sb.append(arr[i][j]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
        SwapColumns1130 s = new SwapColumns1130();
        ReadData rd = s.getData();
        s.printArr(s.swapColumns(rd.ints, rd.columnI, rd.columnJ));
    }



}
