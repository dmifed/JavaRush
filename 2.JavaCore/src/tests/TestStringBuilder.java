package tests;

/**
 * Created by dima on 08.02.2017.
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AAA").append('\n');
        stringBuilder.append("BBB").append('\n');
        stringBuilder.append("CCC").append('\n');

        String s = stringBuilder.toString();
        System.out.println(s);
    }
}
