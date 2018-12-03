package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private int countDir;
    private int countFiles;
    private long countBytes;
    //Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
    //Затем посчитай и выведи следующую информацию:
    //Всего папок - [количество папок в директории и поддиректориях]
    //Всего файлов - [количество файлов в директории и поддиректориях]
    //Общий размер - [общее количество байт, которое хранится в директории]
    public static void main(String[] args) throws IOException {
        String pathToDir = "";
        Solution s = new Solution();
        //List<Path> pathList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            pathToDir = bufferedReader.readLine();
        }
        Path dir = Paths.get(pathToDir);
        if(!Files.isDirectory(dir)){
            System.out.println(dir.toAbsolutePath().toString() + " - не папка");
        }else {
            Files.walkFileTree(dir, s);
            System.out.printf("Всего папок - %d\n", s.countDir-1);
            System.out.printf("Всего файлов - %d\n", s.countFiles);
            System.out.printf("Общий размер - %d\n", s.countBytes);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFiles++;
        countBytes += Files.size(file);
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        countDir++;
        return super.postVisitDirectory(dir, exc);
    }
}
