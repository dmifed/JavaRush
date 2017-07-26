package com.javarush.task.tests;

/**
 * Created by DIMA on 06.06.2017.
 */
public class PrivateConstr {
    private static PrivateConstr privateConstr;
    private PrivateConstr(){}
    public class Inner{
        public void f(){
            System.out.println("Hi");
        }
    }
    public static PrivateConstr getInstance(){
        privateConstr = new PrivateConstr();
        return privateConstr;
    }
    PrivateConstr.Inner i = PrivateConstr.getInstance().new Inner();
}
