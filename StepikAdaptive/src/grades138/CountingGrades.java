package grades138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 06.07.2018.
 */
public class CountingGrades {
    public static void main(String[] args) {
        int countStudents;
        List<Integer> listGrade = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> stringIntegerMap = new TreeMap<>(Comparator.reverseOrder());
        String result;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            countStudents = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < countStudents; i++){
                listGrade.add(Integer.parseInt(bufferedReader.readLine()));
            }
        }catch(IOException e){            System.out.println(e.getMessage());        }

        stringIntegerMap.put("A", countingGrade(listGrade, 5));
        stringIntegerMap.put("B", countingGrade(listGrade, 4));
        stringIntegerMap.put("C", countingGrade(listGrade, 3));
        stringIntegerMap.put("D", countingGrade(listGrade, 2));

        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
            sb.append(entry.getValue());
            sb.append(" ");
        }
        result = sb.toString().trim();
        System.out.println(result);
        /*
        Map<Integer, Integer> integerIntegerMap = listGrade.stream()
                .collect(Collectors.toMap(k -> k, v -> 1, (val1, val2) -> val1+1));

        System.out.println(integerIntegerMap.get(2)
                + " " + integerIntegerMap.get(3)
                + " " + integerIntegerMap.get(4)
                + " " + integerIntegerMap.get(5));

        */
    }
    static int countingGrade(List<Integer> listOfGrades, int grade){
        int countGrade = 0;
        for(int i : listOfGrades){
            if(i == grade){
                countGrade++;
            }
        }
        return countGrade;
    }

}
