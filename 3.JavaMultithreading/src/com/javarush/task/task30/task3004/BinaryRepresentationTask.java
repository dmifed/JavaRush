package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by DIMA on 27.04.2018.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        BinaryRepresentationTask bin = new BinaryRepresentationTask(x);
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            x = b;
            bin.fork();
            return bin.compute() + result;
        }
        bin.join();
        return result;
    }
}
