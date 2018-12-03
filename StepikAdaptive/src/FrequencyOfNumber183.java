import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DIMA, on 01.08.2018
 */
public class FrequencyOfNumber183 {
    private static int[] getArray(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ints = new int[size];
        for(int i = 0; i<size; i++){
            ints[i] = scanner.nextInt();
        }

        return ints;
    }

    private static int frequency(int[] ints){
        int count = 1;
        Arrays.sort(ints);
        for(int i = 1; i<ints.length; i++){
            if(ints[i-1] == ints[i]){
                count++;
                if(count > ints.length/2){
                    return 1;
                }
            }else {
                count = 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(frequency(getArray()));
    }
}
