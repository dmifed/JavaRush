package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution {
    public static class A {
        protected String name = "A";
        public A(String name) {
            this.name += name;
        }
        //public A(){}
    }

    public class B extends A implements Serializable {

        public B(String name) {
            super(name); // вызываем конструктор класса А. Получим А + name
            //System.out.println(super.name);
            //name = super.name;
            this.name += name; // присваиваем переменной нейм новое значение
        }
        private void writeObject(ObjectOutputStream outputStream){
            try{
                outputStream.defaultWriteObject();
                outputStream.writeObject(name);
            }catch (IOException e){
                System.out.println("e write  " + e);
            }

        }
        private void readObject(ObjectInputStream inputStream){
            try{
                inputStream.defaultReadObject();
                name = (String)inputStream.readObject();
                //System.out.println(name);
            }catch (ClassNotFoundException e){
                System.out.println("e  " + e);
            }catch (IOException e2){
                System.out.println("e  2" + e2);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2");
        System.out.println(b.name);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);
        System.out.println("still good2");
        B b1 = (B)ois.readObject();
        System.out.println(b1.name);
    }
}
