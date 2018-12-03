import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DIMA, on 23.08.2018
 */
public class SubstitutionCipher1137 {
    private static Map<String, String> coddingMap(String text, String code){
        Map<String, String> map = new HashMap<>();
        String[] letters = text.split("");
        String[] codes = code.split("");
        if(codes.length != letters.length){
            System.out.println("Wrong input");
            return null;
        }
        for (int i = 0; i < letters.length; i++){
            map.put(letters[i], codes[i]);
        }
        return map;
    }


    private static String coddingString(Map<String, String> encodingMap, String text){
        StringBuilder sb = new StringBuilder();
        String[] letters = text.split("");
        for (String letter : letters){
            sb.append(encodingMap.get(letter));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String code = scanner.nextLine();
        String textToCode  = scanner.nextLine();
        String codeToText = scanner.nextLine();
        scanner.close();

        Map<String, String> mapToCodding = coddingMap(text, code);
        Map<String, String> mapToUnCoding = coddingMap(code, text);

        String codeFromText = coddingString(mapToCodding, textToCode);
        String textFromCode = coddingString(mapToUnCoding, codeToText);
        System.out.println(codeFromText);
        System.out.println(textFromCode);
    }


}
