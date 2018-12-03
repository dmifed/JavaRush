import java.util.HashMap;
import java.util.Map;

/**
 * Created by DIMA, on 03.08.2018
 */
public class RelativelyPrimeNumbers1158 {
    private static Map<Integer, Integer> getPrimeFactors(int number){
        Map<Integer, Integer> mapPrimeFactors = new HashMap<>();

        for(int i = 2; i <= number; i++){
            if(number%i == 0){
                if (mapPrimeFactors.containsKey(i)){
                    mapPrimeFactors.put(i, mapPrimeFactors.get(i) + 1);
                }else {
                    mapPrimeFactors.put(i, 1);
                }
                if(number/i == 1){
                    break;
                }else {
                    number = number/i;
                    --i;
                }
            }
        }
        return mapPrimeFactors;
    }

    private static int calcEyler(int number){
        Map<Integer, Integer> primes = getPrimeFactors(number);
        int count = 1;
        if(primes.containsKey(1)){
            count = number-1;
            return count;
        }
        for(Map.Entry<Integer, Integer> entry : primes.entrySet()){
            count = count * (int)(Math.pow(entry.getKey(), entry.getValue()) - Math.pow(entry.getKey(), entry.getValue()-1));
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(calcEyler(new java.util.Scanner(System.in).nextInt()));
    }
}
