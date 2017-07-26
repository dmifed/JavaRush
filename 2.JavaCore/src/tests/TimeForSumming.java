package tests;

/**
 * Created by dima on 03.04.2017.
 */
public class TimeForSumming {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long k = 0;
        for(long i = 0; i<10_000_000_000L; i++){
            k = i;
            if (k == 1_000_000_00 ) {
                System.out.println(k);
            }
        }
        System.out.println("working " + (System.currentTimeMillis()-startTime)/1000);
    }
}
