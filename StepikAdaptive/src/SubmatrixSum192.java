import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 26.11.2018
 */
public class SubmatrixSum192 {
    private int rows;
    private int columns;
    private int[][] matrix;
    private List<Pair> rowsCombination;
    private List<Pair> columnsCombination;
    private int maxSum = Integer.MIN_VALUE;
    //private int countRowsOfSubMatrix = 0;
    //private int countColumnsOfSubMatrix = 0;
    //private int viceMaxSum = Integer.MIN_VALUE; //for case if the maxSum is sum of whole matrix

    private void generateMatrix(int row, int column){
        rows = row;
        columns = column;
        matrix = new int[row][column];
        for(int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                matrix[i][j] = (int) (Math.random() * 20) - 10;
            }
        }
    }




    private List<Pair> combinations (int limit){
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < limit; i++){
            for (int j = i; j < limit; j++){
                list.add(new Pair(i, j));
            }
        }
        return list;
    }

    private int sumSubmatrix(Pair rows, Pair columns){
        int sum = 0;
        int startRow = rows.start;
        int endRow = rows.end;
        int startColumn = columns.start;
        int endColumn = columns.end;
        for(int i = startRow; i<=endRow; i++){
            for (int j = startColumn; j <= endColumn; j++){
                //System.out.println("matrix[i][j] " + matrix[i][j]);
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private int maxCell(){
        int maxCell = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] > maxCell){
                    maxCell = matrix[i][j];
                }
            }
        }
        return maxCell;
    }

    private void findMaxSum(List<Pair> rows, List<Pair> columns){
        for (Pair rowPair : rows){
            for (Pair columnPair : columns){
                int sum = sumSubmatrix(rowPair, columnPair);
                //System.out.println("sum = " + sum);
                int countRowsOfSubMatrix = rowPair.end - rowPair.start;
                int countColumnsOfSubMatrix = columnPair.end - columnPair.start;
                // && (countRowsOfSubMatrix < matrix.length -1  || countColumnsOfSubMatrix < matrix[0].length - 1 )
                if(sum > maxSum){
                    //viceMaxSum = maxSum;
                    maxSum = sum;
                }
            }
        }
    }

    private int getMaxSum(){
        if(maxSum < 0){
            maxSum = maxCell();
            //System.out.println("max cell");
            return maxSum;
        }else {
            //System.out.println("max");
            return maxSum;
        }
    }

    private void getMatrix(){
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    private void printMatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < arr[0].length; j++){
                sb.append(arr[i][j]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }







    private class Pair{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }

    public static void main(String[] args) {
        SubmatrixSum192 s = new SubmatrixSum192();
        s.getMatrix();
        //s.generateMatrix(100, 100);
        //s.printMatrix(s.matrix);
        s.rowsCombination = s.combinations(s.rows);
        s.columnsCombination = s.combinations(s.columns);
        //System.out.println(s.rowsCombination);
        //System.out.println(s.columnsCombination);
        s.findMaxSum(s.rowsCombination, s.columnsCombination);
        int sum = s.getMaxSum();
        System.out.println(sum);

    }


}
