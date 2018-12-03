/**
 * Created by DIMA, on 03.08.2018
 */
public class StarFigure1125 {
    private static String[][] initMatrix(int size){
        String[][] matrix = new String[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = ".";
            }
        }
        return matrix;
    }

    private static String[][] createStar(String[][] matrix){
        //middle row
        for (int i = 0; i<matrix.length; i++){
            matrix[matrix.length/2][i] = "*";
        }
        //middle column
        for (int i = 0; i<matrix.length; i++){
            matrix[i][matrix.length/2] = "*";
        }
        //main diag
        for (int i = 0; i<matrix.length; i++){
            matrix[i][i] = "*";
        }
        //side diag
        for (int i = 0; i<matrix.length; i++){
            matrix[i][matrix.length-1-i] = "*";
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix){
        StringBuilder sb;
        for(int row = 0; row < matrix.length; row++){
            sb = new StringBuilder();
            for(int column = 0; column<matrix[row].length; column++){
                sb.append(matrix[row][column]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) {
        printMatrix(createStar(initMatrix(new java.util.Scanner(System.in).nextInt())));
    }
}
