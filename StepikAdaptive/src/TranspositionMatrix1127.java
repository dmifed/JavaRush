import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 01.10.2018
 */
public class TranspositionMatrix1127 {
    public static void main(String[] args) {
        List<Integer> originalMatrix = new ArrayList<>();
        List<Integer> traspositionMatris = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int colunm = scanner.nextInt();
        for(int i = 0; i < row * colunm; i++){
            originalMatrix.add(scanner.nextInt());
        }
        for(int i = 0; i < colunm; i++){
            for(int j = 0; j < colunm*row; j += colunm){
                //System.out.println(i + " " + j);
                traspositionMatris.add(originalMatrix.get(j+i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : traspositionMatris){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
