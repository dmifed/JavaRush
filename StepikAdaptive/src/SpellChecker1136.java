import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by DIMA, on 26.07.2018
 */
public class SpellChecker1136 {
    private static List[] getData(){
        List<String> listDict = new ArrayList<>();
        List<String> listWords = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int countWords = scanner.nextInt();
        for(int i = 0; i<countWords; i++){
            listDict.add(scanner.next());
        }
        int countTextLines = scanner.nextInt();
        scanner.useDelimiter("\n");
        for(int i = 0; i<countTextLines; i++){
            String s = scanner.next();
            String[] ss = s.split(" ");
            listWords.addAll(Arrays.asList(ss));
        }
        List[] twoLists = {listDict, listWords.stream().distinct().collect(Collectors.toList())};
        scanner.close();
        return twoLists;
    }

    private static List<String> getWrongWords(List<String> dict, List<String> textWords){
        List<String> wrongWords = new ArrayList<>();
        for (String textWord : textWords){
            boolean needAdd = true;
            for (String dictWord : dict){
                if (textWord.equalsIgnoreCase(dictWord)){
                    needAdd = false;
                    break;
                }
            }
            if(needAdd){
                wrongWords.add(textWord);
            }
        }
        return wrongWords;
    }

    private static void printList(List<String> list){
        for(String s : list){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        List[] data = getData();
        List<String> dict = data[0];
        List<String> textWords = data[1];
        printList(getWrongWords(dict, textWords));
    }
}
