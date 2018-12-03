package typeValidator384;

import java.util.List;

/**
 * Created by DIMA, on 05.10.2018
 */
public class NaiveQualityControl {
    public static boolean check(List<Box<? extends Bakery>> boxes) {
        for(Box b : boxes){
            System.out.println(b.get());
            if (!(b.get() instanceof Bakery)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Box<? extends Bakery>> list = Violator.defraud();
        System.out.println(check(list));
        //System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
