import java.util.Scanner;

/**
 * Created by DIMA, on 02.08.2018
 */
public class Transposing1133 {
    private static int[][] getMatrix(){
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column<matrix[row].length; column++){
                matrix[row][column] = scanner.nextInt();
            }
        }
        scanner.close();
        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        StringBuilder sb;
        for(int row = 0; row < matrix.length; row++){
            sb = new StringBuilder();
            for(int column = 0; column<matrix[row].length; column++){
                sb.append(matrix[row][column]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static int[][] transpotingMatrix(int[][] matrix){
        int[][] transpotingMatrix = new int[matrix[0].length][matrix.length];
        for(int row = 0; row < transpotingMatrix.length; row++){
            for (int column = 0 ; column < transpotingMatrix[row].length; column++){
                transpotingMatrix[row][column] = matrix[column][row];
            }
        }
        return transpotingMatrix;


    }

    public static void main(String[] args) {
        printMatrix(transpotingMatrix(getMatrix()));
    }
}
