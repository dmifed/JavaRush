package com.javarush.task.tests;

/**
 * Created by dima on 25.05.2017.
 */
public class A {
    @Override
    public String toString() {
        return "toString A{}";
    }
    public A(){
        System.out.println("constructor A");
    }
    static {
        System.out.println("static A");
    }
    {
        System.out.println("{}A");
    }

    /**
     * Created by DIMA on 10.05.2018.
     */
    public static class Test {
        int[] arr = {2,16,16,2};
        public void compressArr(int[] arr){
            for (int j = 0; j<4; j++){
                for (int i = 3; i > 0; i--){
                    if(arr[i] != 0 && arr[i-1] == 0){
                        int tmp = arr[i-1];
                        arr[i-1] = arr[i];
                        arr[i] = tmp;
                    }
                }
            }
        }

        public void megreArr(int[] arr){
            for (int i = 0; i < arr.length-1; i++){
                if(arr[i] == arr[i+1]){
                    int v = arr[i];
                    arr[i] = v*2;
                    arr[i+1] = 0;
                    compressArr(arr);
                }
            }
        }
        public static void main(String[] args) {
            Test test = new Test();
            test.compressArr(test.arr);
            test.megreArr(test.arr);

            for (int i = 0 ; i<test.arr.length; i++){            System.out.print(test.arr[i] + " ");        }
        }
    }
}
