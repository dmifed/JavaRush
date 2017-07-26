package com.javarush.task.tests;

/**
 * Created by DIMA on 06.06.2017.
 */
public class InheritClassOverwrite extends SuperInheritClassOverwrite{
    public Class2 c2;
    public class Class2{
        public Class2(){
            System.out.println("InheritClassOverwrite.Class2");
        }
    }
    public InheritClassOverwrite(){
        System.out.println("new InheritClassOverwrite");
        c2 = new Class2();
    }

    public static void main(String[] args) {
        InheritClassOverwrite i1 = new InheritClassOverwrite();
        System.out.println();
        SuperInheritClassOverwrite si1 = new SuperInheritClassOverwrite();
    }

}

class SuperInheritClassOverwrite{
    public Class2 c2;
    public class Class2{
        public Class2(){
            System.out.println("SuperInheritClassOverwrite.Class2");
        }
    }
    public SuperInheritClassOverwrite(){
        System.out.println("new SuperInheritClassOverwrite");
        c2 = new Class2();
    }

}