package grades160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DIMA on 13.07.2018.
 */
public class CalculatePercentGrades {
    private String[] input;
    private int lenght;
    private Map<String,Integer> getMapGrades(){
        Map<String, Integer> map = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            input = bufferedReader.readLine().split(" ");
            lenght = input.length;
            for(String s : input){
                if(!map.containsKey(s)){
                    map.put(s, 1);
                }else {
                    int value = map.get(s);
                    map.put(s, value+1);
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return map;
    }
    public double calcPercentKeyInMap(String key){
        Map<String, Integer> map = getMapGrades();
        if(!map.containsKey(key)){
            return 0;
        }else {
            return ((double)map.get(key))/lenght;
        }
    }

    public static void main(String[] args) {
        CalculatePercentGrades percentGrades = new CalculatePercentGrades();
        System.out.println(percentGrades.calcPercentKeyInMap("A"));
    }


}
