import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 27.07.2018
 */
public class SumTwoNeighbouringNumbers1115 {
    private static int[] getArray(){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] ints = new int[strings.length];
        for(int i = 0; i<ints.length; i++){
            ints[i] = Integer.parseInt(strings[i]);
        }
        scanner.close();
        return ints;
    }

    private static int[] calcNeighbours(int[] source){
        int[] target = new int[source.length];
        if(source.length == 1){
            target[0] = source[0];
            return target;
        }
        target[0] = source[1] + source[source.length-1];
        target[target.length-1] = source[0] + source[source.length-2];
        for (int i = 1; i < source.length-1; i++){
            target[i] = source[i-1] + source[i+1];
        }
        return target;
    }

    private static void printArrayWithSpaces(int[] arr){
        System.out.println(IntStream.of(arr).boxed().map(x -> x.toString()).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) {
        printArrayWithSpaces(calcNeighbours(getArray()));
    }
}
