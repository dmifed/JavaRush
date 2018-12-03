/**
 * Created by DIMA, on 23.08.2018
 */
public class ValueOfFunction1141 {
    public static float f(float x){
        if(x <= -2) return 1 - (x + 2f) * (x + 2f);
        if (x <= 2) return x / -2f;
        return (x - 2f) * (x - 2f) + 1;
    }

    public static void main(String[] args) {
        System.out.println(f(1f));
    }
}
