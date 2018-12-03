package others;

import java.util.stream.LongStream;

/**
 * Created by DIMA on 27.06.2018.
 */
public class NumberUtils {
    static boolean isPrime(long num){
        if(num%2 == 0){
            //System.out.println("2");
            return false;
        }
        for (long i = 3; i<num; i +=2 ){
            if(num%i == 0){
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public static void printLongStream (LongStream longStream){
        //System.out.println("start print!");
        long[] longs = longStream.toArray();
        for(long l : longs){
            System.out.print(l + " ");
        }
        //System.out.println("fin print!");
    }
}
