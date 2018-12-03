import java.util.Scanner;

/**
 * Created by DIMA, on 02.08.2018
 */
public class MatrixDiagonal1124 {
    private static int[][] matrix;
    private static int[][] initMatrix(int size){
        int[][] matrix = new int[size][size];

        return matrix;
    }

    private static void fillRow(int[][] matrix, int row){
        int elem = 0;
        for (int i = row; i<matrix.length; i++){
            matrix[row][i] = elem++;
        }
    }
    private static void fillColumn(int[][] matrix, int column){
        int elem = 0;
        for (int i = column; i<matrix.length; i++){
            matrix[i][column] = elem++;
        }
    }

    private static void fillByDiag(int[][] matrix){
        for (int i = 0; i<matrix.length; i++){
            fillRow(matrix, i);
            fillColumn(matrix, i);
        }
    }

    private static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr[i].length; j++){
                sb.append(arr[i][j]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrix = initMatrix(scanner.nextInt());
        scanner.close();
        fillByDiag(matrix);
        printArr(matrix);
    }
}
