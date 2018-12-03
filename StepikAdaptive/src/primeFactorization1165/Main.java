package primeFactorization1165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 13.07.2018.
 */
public class Main {
    private List<Integer> findPrimes(int fin){
        int[] allNumbers = new int[fin-1];
        boolean[] isPrimes = new boolean[fin-1];
        for (int i = 0; i < fin-1; i++){
            allNumbers[i] = 2+i;
            isPrimes[i] = true;
        }
        for (int i = 2; i*i <= fin; i++ ){
            if(isPrimes[i-2]){
                for(int j = allNumbers[i-2]*allNumbers[i-2]; j<=allNumbers.length+1; j = j+allNumbers[i-2]){
                    isPrimes[j-2] = false;
                    //System.out.println("loop j = " + j);
                }
                //System.out.println("end loop " + i);
            }
        }
        List<Integer> allPrimes = new ArrayList<>();
        for(int i = 0; i < allNumbers.length; i++){
            if(isPrimes[i]){
                allPrimes.add(allNumbers[i]);
            }
        }
        //Collections.sort(allPrimes);
        return allPrimes;
    }

    private List<Integer> factorizationByPrimes(int number){
        List<Integer> fastorization = new ArrayList<>();
        List<Integer> primes = findPrimes(number);
        for(int i = 0; i<primes.size();){
            if(number%primes.get(i) == 0){
                number = number/primes.get(i);
                fastorization.add(primes.get(i));
                if(number == 1){
                    return fastorization;
                }
            }
            else i++;
        }
        return fastorization;
    }

    public void printFactorization(){
        int number = readNumber();
        if(number<2){
            System.out.println("number = " + number);
        }
        List<Integer> res = factorizationByPrimes(number);
        String out = res.stream().map(t -> t.toString()).collect(Collectors.joining(" "));
        System.out.println(out);
    }

    private int readNumber(){
        int number = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            number =  Integer.parseInt(bufferedReader.readLine());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return number;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.printFactorization();

    }
}
