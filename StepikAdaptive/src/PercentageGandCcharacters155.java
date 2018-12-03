import java.util.Scanner;

/**
 * Created by DIMA, on 31.07.2018
 */
public class PercentageGandCcharacters155 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.next().split("");
        scanner.close();
        int countGorC = 0;
        for (String ss : s){
            if(ss.equalsIgnoreCase("G") || ss.equalsIgnoreCase("C")) countGorC++;
        }
        double gc = (double) countGorC*100/s.length;
        System.out.println(gc);
    }
}
