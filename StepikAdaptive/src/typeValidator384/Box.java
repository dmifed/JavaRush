package typeValidator384;

import java.util.ArrayList;

/**
 * Created by DIMA, on 05.10.2018
 */
public class Box<T> {
    T item;
    void put(T item){
        this.item = item;
    }
    T get(){
        return item;
    }

}
