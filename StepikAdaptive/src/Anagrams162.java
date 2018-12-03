import java.util.Scanner;

/**
 * Created by DIMA, on 13.08.2018
 */
public class Anagrams162 {
    private static boolean isAnagram(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        String first = s1.toLowerCase();
        String second = s2.toLowerCase();
        if(first.equals(second)) return true;
        if(first.length() != second.length()) return false;
        String[] original = first.split("");
        String[] test = second.split("");
        boolean[] isUsed = new boolean[test.length];
        for(String s : original){
            for (int i = 0; i<test.length; i++){
                if(test[i].equals(s) && !isUsed[i]){
                    isUsed[i] = true;
                    sb.append(test[i]);
                    break;
                }
            }

        }
        return first.equals(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(isAnagram(s1, s2) ? "True" : "False");
        scanner.close();
    }
}
