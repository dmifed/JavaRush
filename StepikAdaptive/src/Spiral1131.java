import java.util.Scanner;

/**
 * Created by DIMA, on 02.08.2018
 */
public class Spiral1131 {
    private static int elem = 0;
    private static int[][] arr;
    private static void goRight(int[][] arr, int row, int start, int end){
        for(int i = start; i<end; i++){
            arr[row][i] = ++elem;
        }
    }

    private static void goDown(int[][] arr, int column, int start, int end){
        for(int i = start; i<end; i++){
            arr[i][column] = ++elem;
        }
    }

    private static void goLeft(int[][] arr, int row, int start, int end){
        for(int i = start; i>end; i--){
            arr[row][i] = ++elem;
        }
    }

    private static void goUp(int[][] arr, int column, int start, int end){
        for(int i = start; i>end; i--){
            arr[i][column] = ++elem;
        }
    }

    private static void fillSpiral(int[][] arr){
        if(arr.length%2 != 0){
            arr[arr.length/2][arr.length/2] = arr.length * arr.length;
        }
        int step = arr.length-1;
        int delta = 0;
        while (step > 0){
            goRight(arr, delta, delta, arr.length-1-delta);
            goDown(arr, arr.length-1-delta, delta, arr.length-1-delta);
            goLeft(arr, arr.length-1-delta, arr.length-1-delta, delta);
            goUp(arr, delta, arr.length-1-delta, delta);
            delta++;
            step -= 2;
        }
    }

    private static int[][] getArr(int size){
        return new int[size][size];
    }

    private static void printArr(int[][] matrix){
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
        Scanner scanner = new Scanner(System.in);
        int[][] arr = getArr(scanner.nextInt());
        fillSpiral(arr);
        printArr(arr);
    }

}
