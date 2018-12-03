/**
 * Created by DIMA, on 30.10.2018
 */
public class SumIntAndBoolean {
    public static void main(String[] args) {
        int a = 5;
        boolean b = false;
        a = b ? ++a : a;
        System.out.println(a);
    }
}
