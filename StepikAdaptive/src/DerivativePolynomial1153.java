import java.util.*;

/**
 * Created by DIMA, on 22.11.2018
 */
public class DerivativePolynomial1153 {

    private class Summand{
        int multFactor = 1;
        int pow = 0;

        Summand(String summand){
            int sign = summand.startsWith("-") ?  -1 : 1;
            if(summand.startsWith("+") || summand.startsWith("-")){
                summand = summand.substring(1);
            }
            String patternToExtraxtX = "\\*";
            //String patternToExtraxtX = "(?=[^[x{1}\\d*]])";
            String[] items = summand.split(patternToExtraxtX);
            for(String s : items) {
                if (s.startsWith("x^")) {
                    pow = Integer.parseInt(s.split("\\^")[1]);
                } else if (s.equals("x")){
                    pow = 1;
                }else {
                    multFactor *= Integer.parseInt(s);
                }
            }
            multFactor *= sign;
        }

        @Override
        public String toString() {
            return multFactor + "*x^" + pow;
        }
    }

    private String[] getRawArr(String polinom){
        String pattren = "(?=[+-])";
        return polinom.split(pattren);
    }

    //private void printArr(String[] arr){
        //System.out.println(Arrays.stream(arr).collect(Collectors.joining("; ")));
    //}

    private String getDerriative(Summand[] summands){
        Map<Integer, Integer> mapOfSummands = new TreeMap<>();
        Map<Integer, Integer> mapOfDerriative = new TreeMap<>(Comparator.reverseOrder());
        for(Summand s : summands){
            //System.out.println(s);
            int key = s.pow;
            if(mapOfSummands.containsKey(key)){
                int value = s.multFactor + mapOfSummands.get(key);
                mapOfSummands.put(key, value);
            }else {
                mapOfSummands.put(key, s.multFactor);
            }
        }
        for(Map.Entry<Integer, Integer> entry : mapOfSummands.entrySet()){
            if(entry.getKey() > 1){
                mapOfDerriative.put(entry.getKey()-1, entry.getValue()*entry.getKey());
            }
            if(entry.getKey() == 1){
                mapOfDerriative.put(entry.getKey()-1, entry.getValue()*entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : mapOfDerriative.entrySet()){
            int pow = entry.getKey();
            int value = entry.getValue();

            if(pow > 1){
                if(value == 1){
                    sb.append("+x^").append(pow);
                }else if(value == -1){
                    sb.append("-x^").append(pow);
                }else if(value > 0) {
                    sb.append("+").append(value).append("*x^").append(pow);
                }else {
                    sb.append(value).append("*x^").append(pow);
                }
            }

            if(pow == 1){
                if(value == 1){
                    sb.append("+x");
                }else if(entry.getValue() == -1){
                    sb.append("-x");
                }else if(value > 0){
                    sb.append("+").append(value).append("*x");
                }else {
                    sb.append(value).append("*x");
                }
            }
            if(pow == 0){
                if(value > 0){
                    sb.append("+").append(value);
                }else {
                    sb.append(value);
                }
            }
        }
        String s = sb.toString();
        if(s.startsWith("+")){
            return s.substring(1);
        }else {
            return s;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DerivativePolynomial1153 d = new DerivativePolynomial1153();
        String[] summands = d.getRawArr(scanner.next());
        scanner.close();
        //d.printArr(summands);
        Summand[] summands1 = new Summand[summands.length];

        for(int i = 0; i < summands.length; i++){
            Summand summand = d.new Summand(summands[i]);
            summands1[i] = summand;
        }

        String s = d.getDerriative(summands1);
        System.out.println(s);


    }
}
