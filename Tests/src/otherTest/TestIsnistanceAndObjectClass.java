package otherTest;

import java.util.Objects;

/**
 * Created by DIMA on 03.07.2018.
 */
public class TestIsnistanceAndObjectClass {
    class A{}
    class B extends A{}
    class C extends B {}
    public static void main(String[] args) {
        System.out.println(Object.class.isInstance(A.class)); //true  ??
        System.out.println(Integer.class.isInstance(Object.class)); //false
        System.out.println(Number.class.isInstance(Integer.class)); //false
        System.out.println(Integer.class.isInstance(Number.class)); //false
        System.out.println();
        System.out.println(A.class.isInstance(B.class)); //false
        System.out.println(B.class.isInstance(A.class)); //false
        TestIsnistanceAndObjectClass t = new TestIsnistanceAndObjectClass();
        A aa = t.new A();
        B bb = t.new B();
        C cc = t.new C();
        Object oo = new Object();
        System.out.println(A.class.isInstance(bb)); //true //Can object bb cast to class A
        System.out.println(A.class.isInstance(cc)); //true //Can object cc cast to class A
        System.out.println(B.class.isInstance(aa)); //false
        System.out.println(A.class.isInstance(oo)); //false
        System.out.println(Object.class.isInstance(aa)); //true //Can object aa cast to class Object
        System.out.println(aa instanceof B); //false
        System.out.println(bb instanceof A); //true
    }
}
