import java.util.List;

/**
 * Created by DIMA, on 28.11.2018
 */
public class Wildcards374 {
    // Different Bakeries that should be packed to Box'es and delivered to customers
    class Bakery {}
    class Cake extends Bakery {}
    class Pie extends Bakery {}
    class Tart extends Bakery {}

    // This (of course) can be packed in box, but we want to disable it's delivery to customers
    class Paper {}

    // Implementing class exists that is used to pack everything
    interface Box<T> {
        public void put(T item);
        public T get();
    }

    /**

     Need to modify method signature in a way that will ensure that different Bakeries
     (but not anything else, e.g. Paper) can be delivered

     */
    class Deliveryman {
        public void   deliver(Box<? extends Bakery> box) {
            // He knows how to do this, leave unchanged
            System.out.println("Deliver " + box);
            //return box;
        }

    }

    class BoxImpl<T> implements Box<T>{
        private T item;

        @Override
        public void put(T item) {
            this.item  = item;
        }
        @Override
        public T get() {
            return item;
        }

        @Override
        public String toString() {
            return item.getClass().getTypeName();
        }
    }

    public static void main(String[] args) {
        Wildcards374 w = new Wildcards374();
        Bakery bakery = w.new Bakery();
        Cake cake = w.new Cake();
        Pie pie = w.new Pie();
        Bakery bakeryTart = w.new Tart();
        Paper paper = w.new Paper();

        Box<Bakery> bakeryBox = w.new BoxImpl<>();
        bakeryBox.put(bakery);
        //System.out.println(bakeryBox);

        Box<Bakery> pieBox = w.new BoxImpl<>();
        pieBox.put(pie);
        //System.out.println(pieBox);

        Box<Cake> cakeBox = w.new BoxImpl<>();
        cakeBox.put(cake);
        //System.out.println(cakeBox);

        Box<Paper> paperBox = w.new BoxImpl<>();
        paperBox.put(paper);
        //System.out.println(paperBox);

        Deliveryman d = w.new Deliveryman();
        d.deliver(bakeryBox);
        d.deliver(pieBox);
        d.deliver(cakeBox);
        //d.deliver(paperBox);


    }

}
