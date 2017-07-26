package tests;

import com.javarush.task.task20.task2023.Solution;

/**
 * Created by dima on 30.03.2017.
 */
public class NasledovanieAndModificators {
        public static void main(String[] s) {
            A a = new C();
            a.method2();
        }

        public static class A {
            protected void method1() {

                System.out.println("A class, method1");
            }

            private void method2() {
                System.out.println("A class, method2");
            }
        }
/*
        public static class B extends A {
            public void method1() {
                super.method1();
                System.out.println("B class, method1");
            }

            public void method2() {
                System.out.println("B class, method2");
            }
        }
*/
        public static class C extends A {
            public void method1() {
                System.out.println("C class, method1");
            }

            public void method2() {
                System.out.println("C class, method2");
            }
        }
}
