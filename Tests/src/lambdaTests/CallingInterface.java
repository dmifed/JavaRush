package lambdaTests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 19.06.2018.
 */
public class CallingInterface {
    List<FunctionalMethods> functionalMethods = new ArrayList<>();
    public void add (FunctionalMethods ff){
        functionalMethods.add(ff);
    }
    public void play(){
        for (FunctionalMethods f : functionalMethods){
            f.g2("yyy!");
        }
    }
}
