import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA, on 17.09.2018
 */
public class TestChangeObjectInList {
    static List<Item> list= new ArrayList<>();
    private static class Item{
        int value;
        String name;
        boolean test;

        public Item(int value, String name) {
            this.value = value;
            this.name = name;
            test = false;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", name='" + name + '\'' +
                    ", test=" + test +
                    '}';
        }
    }

    public static void main(String[] args) {
        Item i1 = new Item(15, "S");
        Item i2 = new Item(20, "W");
        Item i3 = new Item(30, "QQ");
        list.add(i1);
        list.add(i2);
        list.add(i3);
        System.out.println(list);
        list.get(0).test = true;
        Item iN = list.get(1);
        iN.test = true;
        Item i3N = list.get(2);
        i3N.test = true;
        list.set(2, i3N);

        System.out.println(list);
    }



}
