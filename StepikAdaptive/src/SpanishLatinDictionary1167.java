import java.util.*;

/**
 * Created by DIMA, on 07.08.2018
 */
public class SpanishLatinDictionary1167 {
    private static Map<String, Set<String>> getLatinToSpainshDict(){
        Map<String, Set<String>> mapLatinToSpanish = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++){
            scanner.useDelimiter("\\n");
            String line = scanner.next();
            String word = line.split(" - ")[0];
            String[] translate = line.split(" - ")[1].split(", ");
            Set<String> translateWords = new TreeSet<>();
            for (String s : translate){
                translateWords.add(s);
            }
            mapLatinToSpanish.put(word, translateWords);
        }
        return mapLatinToSpanish;
    }

    private static Map<String, Set<String>> getReverseDict(Map<String, Set<String>> mapLatinToSpanish){
        Map<String, Set<String>> mapSpanishToLatin = new TreeMap<>();
        for(Map.Entry<String, Set<String>> entry : mapLatinToSpanish.entrySet()){
            Set<String> spanishWords = entry.getValue();
            String latinWord = entry.getKey();
            for(String s : spanishWords){
                if(!mapSpanishToLatin.containsKey(s)){
                    Set<String> latinWords = new TreeSet<>();
                    latinWords.add(latinWord);
                    mapSpanishToLatin.put(s, latinWords);
                }else {
                    mapSpanishToLatin.get(s).add(latinWord);
                }
            }
        }
        return mapSpanishToLatin;
    }

    private static void printDict(Map<String, Set<String>> dict){
        System.out.println(dict.size());
        for(Map.Entry<String, Set<String>> entry : dict.entrySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(" - ");
            for (String s : entry.getValue()){
                sb.append(s).append(", ");
            }
            String line = sb.toString();
            line = line.substring(0, line.length()-2);
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        printDict(getReverseDict(getLatinToSpainshDict()));
    }
}
