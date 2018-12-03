package others;

import java.util.stream.LongStream;

/**
 * Created by DIMA on 27.06.2018.
 */
public class ParallelFilteringOfPrimeNumbers {
    public static void main(String[] args) {
        //System.out.println(NumberUtils.isPrime(1646461188461561111L));
        NumberUtils.printLongStream(createPrimesFilteringStream(5, 29));
    }

    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        LongStream longStream = LongStream.rangeClosed(rangeBegin, rangeEnd).filter(NumberUtils::isPrime).parallel();


        return longStream;
    }


}
