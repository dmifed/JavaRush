package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayDeque<File> fileQueue = new ArrayDeque<>();
        List<String> listResult = new ArrayList<>();
        File f = new File(root);
        if(!f.isDirectory()){
            listResult.add(root);
            return listResult;
        }else {
            fileQueue.addLast(f);
            while (!fileQueue.isEmpty()){
                File dirInQueue = fileQueue.pollFirst();
                File[] filesInDirectory = dirInQueue.listFiles();
                for(File fileInDirectory : filesInDirectory){
                    if(fileInDirectory.isDirectory()){
                        fileQueue.addLast(fileInDirectory);
                    }else{
                        listResult.add(fileInDirectory.getAbsolutePath());
                    }
                }

            }
        }
        return listResult;

    }

    public static void main(String[] args) throws IOException{
        File dir = new File("E:\\test31Level");
        List<String> l = getFileTree(dir.getAbsolutePath());
        for(String s : l){
            System.out.println(s);
        }
    }
}
