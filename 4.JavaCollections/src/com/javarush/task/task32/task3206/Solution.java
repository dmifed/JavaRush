package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;

/* 
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
    public <T extends Item> T getProxy(Class<T> item, Class<?>...arg){
        Class<?>[] interfaces = new Class[arg.length+1];
        interfaces[0] = item;
        for(int i = 1; i<arg.length+1; i++){
            interfaces[i] = arg[i-1];
        }

        return (T)Proxy.newProxyInstance
                (this.getClass().getClassLoader(),
                        interfaces,
                        new ItemInvocationHandler());
    }
    //4. В методе getProxy при вызове Proxy.newProxyInstance передай
    // this.getClass().getClassLoader() в качестве первого аргумента.

    //В классе Solution создай публичный метод getProxy:
    //1) Метод getProxy должен возвращать прокси для любого интерфейса, который наследуется от Item.
    //2) getProxy должен иметь два параметра. Первый - класс возвращаемого типа,
    // второй - классы дополнительных интерфейсов (используй аргумент переменной длины ...).
    //3) Используй ItemInvocationHandler для создания прокси.
}