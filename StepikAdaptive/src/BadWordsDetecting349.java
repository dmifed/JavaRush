import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by DIMA on 17.07.2018.
 */
public class BadWordsDetecting349 {


    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {

        //return badWords.stream().filter(s -> s.contains(text)).sorted();
        //get stream from text and remove all word contains in badWords list
        return Arrays.stream(text.split(" ")).distinct().filter(badWords::contains).sorted();


        //badWords.stream().distinct();
    }

    public static void main(String[] args) {
        String text = "aaa bsd aa agd huh ajk aaaa kjj ahk";
        List<String> badWords = new ArrayList<>(Arrays.asList("aaa", "huh", "ajk", "bb", "ahk"));
        List<String> list = createBadWordsDetectingStream(text, badWords).collect(Collectors.toList());
        System.out.println(list);
    }
}
