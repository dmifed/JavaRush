package typeValidator384;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA, on 05.10.2018
 */
public class Violator {
    public static List<Box<? extends Bakery>> defraud() {
        List<Box<? extends Bakery>> boxList = new ArrayList<>();
        Box<Bakery> b1 = new Box<>();
        b1.put(new Bakery());
        Box<Cake> b2  = new Box<>();
        b2.put(new Cake());
        Box b3 = new Box<>();
        b3.put(new Paper());
        boxList.add(b1);
        boxList.add(b2);
        boxList.add(b3);


        // Add implementation here

        return boxList;
    }
}
