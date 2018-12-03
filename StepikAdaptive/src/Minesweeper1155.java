import java.util.Scanner;

/**
 * Created by DIMA, on 30.10.2018
 */
public class Minesweeper1155 {
    private static int[][] arr;
    private static void fillArray(){
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            String[] cells = scanner.next().split("");
            //printTestArr(cells);
            for(int j = 0; j < columns; j++){
                if(cells[j].equals(".")){
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = -1;
                }
            }
        }
    }

    private static void printArr(int[][] ints){
        for(int[] ii : ints){
            StringBuilder sb = new StringBuilder();
            for(int i : ii){
                sb.append( i != -1 ? i : "*");
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean checkMine(int row, int column){
        if(row < 0 || row >= arr.length) return false;
        if(column < 0 || column >= arr[0].length) return false;
        return arr[row][column] == -1;
    }

    private static void countingNeightbouringMines(int row, int column){
        int countMines = 0;
        for(int i = row - 1; i <= row + 1; i++){
            for (int j = column -1; j <= column + 1; j++){
                countMines = checkMine(i, j) ? ++countMines : countMines;
            }
        }
        arr[row][column] = countMines;
    }

    public static void main(String[] args) {
        fillArray();
        for (int row = 0; row < arr.length; row++){
            for(int column = 0; column < arr[0].length; column++){
                if(arr[row][column] != -1){
                    countingNeightbouringMines(row, column);
                }
            }
        }
        printArr(arr);
    }
}
