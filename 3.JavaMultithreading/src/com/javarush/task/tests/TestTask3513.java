package com.javarush.task.tests;

/**
 * Created by DIMA on 10.05.2018.
 */
public class TestTask3513 {
    int[] arr = new int[]{0, 0, 2, 2};

    public void compressArr(int[] arr) {
        for(int j = 0; j < 4; ++j) {
            for(int i = 3; i > 0; --i) {
                if(arr[i] != 0 && arr[i - 1] == 0) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    public void megreArr(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            if(arr[i] == arr[i + 1] && arr[i] != 0) {
                int v = arr[i];
                arr[i] = v * 2;
                arr[i + 1] = 0;
                this.compressArr(arr);
            }
        }
    }

    public static void main(String[] args) {
        TestTask3513 test = new TestTask3513();
        test.compressArr(test.arr);
        test.megreArr(test.arr);

        for(int i = 0; i < test.arr.length; ++i) {
            System.out.print(test.arr[i] + " ");
        }
    }
}

