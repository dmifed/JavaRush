/**
 * Created by DIMA, on 06.09.2018
 */
public class RandomStringOfIntegers {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++){
            int r = (int)(Math.random() * 10);
            sb.append(r).append(" ");
        }
        System.out.println(sb.toString().trim());


    }
}
