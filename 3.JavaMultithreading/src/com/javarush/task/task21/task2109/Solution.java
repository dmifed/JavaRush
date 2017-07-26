package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public Object clone()throws CloneNotSupportedException{
            //System.out.println("call clone from A");
            return new A(i,j);
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            return 31*i + j;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(!(obj instanceof A))return false;
            if(obj == this) return true;
            if(this.hashCode() == obj.hashCode()){
                A objA = (A) obj;
                if (this.getI() == objA.getI() && this.getJ() == objA.getJ()) return true;
            }
            return false;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        public Object clone() throws CloneNotSupportedException{
            //System.out.println("call clone from B");
            throw new CloneNotSupportedException();
        }
        public String getName() {
            return name;
        }

        public int hachCode(){
            int str = getName() != null ? getName().hashCode() : 0;
            return 31*getI() + getJ() + str;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(!(obj instanceof B))return false;
            if(obj == this) return true;
            if(this.hashCode() == obj.hashCode()){
                B objB = (B) obj;
                if (this.getI() == objB.getI() && this.getJ() == objB.getJ() && this.getName() == objB.getName()) return true;
            }
            return false;
        }

    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public Object clone()throws CloneNotSupportedException{
            //System.out.println("call clone from C");
            return new C(getI(), getJ(), getName());
        }
        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(!(obj instanceof C))return false;
            if(obj == this) return true;
            if(this.hashCode() == obj.hashCode()){
                C objC = (C) obj;
                if (this.getI() == objC.getI() && this.getJ() == objC.getJ() && this.getName() == objC.getName()) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            A a = new A(1,2);
            A aClone = (A)a.clone();
            System.out.println(a);
            System.out.println(aClone);
            System.out.println();

            C c = new C(111, 222, "CCC");
            C cClone = (C) c.clone();
            System.out.println(c);
            System.out.println(cClone);
            System.out.println();

            B b = new B(11,22,"BB");
            System.out.println(b);
            B bClone = (B) b.clone();
            System.out.println(bClone);
            System.out.println();

        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }


    }
}
