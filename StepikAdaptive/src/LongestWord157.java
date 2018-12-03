import java.util.Scanner;

/**
 * Created by DIMA, on 15.08.2018
 */
public class LongestWord157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        String[] words = scanner.next().split(" ");
        scanner.close();
        int maxLen = 0;
        String maxWord = "";

        for (String word : words){
            if(word.length() > maxLen){
                maxLen = word.length();
                maxWord = word;
            }
        }
        System.out.println(maxWord);


    }
}
