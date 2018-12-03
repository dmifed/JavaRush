package listsBigDeal3103;

import java.util.*;

/**
 * Created by DIMA, on 06.08.2018
 */
public class Main {
    public static void main(String[] args) {


        List<Integer> delList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            delList.add(i);
        }


        //*** change this code which raises ConcurrentModificationException
        Iterator<Integer> integerIterator = delList.iterator();
        while (integerIterator.hasNext()){
            int i;
            if((i = integerIterator.next()) < 10){
                integerIterator.remove();
            }
        }
        //***


        System.out.println(delList);

    }
}
