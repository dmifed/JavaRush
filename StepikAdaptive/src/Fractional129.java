/**
 * Created by DIMA, on 03.08.2018
 */
public class Fractional129 {
    public static void main(String[] args) {
        String[] parts = new java.util.Scanner(System.in).next().split("\\.");
        if(parts.length == 1){
            System.out.println(0);
        }else {
            System.out.println(parts[1].split("")[0]);
        }

    }
}
