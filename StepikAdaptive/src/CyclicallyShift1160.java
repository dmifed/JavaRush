import java.util.Scanner;

/**
 * Created by DIMA, on 08.08.2018
 */
public class CyclicallyShift1160 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] shiftedArray = new int[scanner.nextInt()];
        for (int i = 1; i < shiftedArray.length; i++){
            shiftedArray[i] = scanner.nextInt();
        }
        shiftedArray[0] = scanner.nextInt();
        scanner.close();
        StringBuilder sb = new StringBuilder();
        for(int a : shiftedArray){
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
