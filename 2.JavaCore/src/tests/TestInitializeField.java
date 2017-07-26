package tests;

/**
 * Created by dima on 14.03.2017.
 */
public class TestInitializeField {
    private String name;
    private int id;

    public TestInitializeField (String name){
        this.name = name;
    }
     public int getId(){
         return this.id;
     }
     public String getName(){
         return this.name;
     }
     public void setId(int id){
         this.id = id;
     }

    public static void main(String[] args) {
        TestInitializeField t1 = new TestInitializeField("AAA");
        System.out.println(t1.getName());
        System.out.println(t1.getId());
        t1.setId(10);
        System.out.println(t1.getId());
    }
}
