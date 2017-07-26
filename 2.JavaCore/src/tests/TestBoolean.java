package tests;

/**
 * Created by dima on 15.03.2017.
 */
public class TestBoolean {
    private boolean b;
    private String s;
    void setBoolean(boolean b){
        this.b = b;
    }

    public static void main(String[] args) {
        TestBoolean t1 = new TestBoolean();
        System.out.println(t1.b);
        t1.setBoolean(true);
        System.out.println(t1.b);
        System.out.println(t1.s);
    }


}
