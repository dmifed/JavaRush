package googlim;

/**
 * Created by DIMA on 05.06.2017.
 */
public class Intern {
    public static void main(String[] args) {
        String s1 = new String("a");;
        String s2 = "a";
        String s3 = s1.intern();

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s2==s3);
        System.out.println(s2.equals(s3));
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));
    }
}
