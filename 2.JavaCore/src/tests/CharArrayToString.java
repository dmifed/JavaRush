package tests;

/**
 * Created by dima on 01.03.2017.
 */
public class CharArrayToString {
    public static void main(String[] args) {
        String s= "abcdef";
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = chars.length-1; i>=0; i--){
            stringBuilder.append(chars[i]);
        }
        System.out.println(stringBuilder.toString());
    }


}
