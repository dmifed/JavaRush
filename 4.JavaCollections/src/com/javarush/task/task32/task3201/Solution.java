package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        //В метод main приходят три параметра:
        //1) fileName - путь к файлу;
        //2) number - число, позиция в файле;
        //3) text - текст.
        //        Записать text в файл fileName начиная с позиции number.
        //Запись должна производиться поверх старых данных, содержащихся в файле.
        //Если файл слишком короткий, то записать в конец файла.
        //Используй RandomAccessFile и его методы seek и write.

        //String fileName = "E:\\JavaRushTests\\test32level\\long.txt";
        //int number = 3330;
        //String text = "!!!TEXT 11 TEXT!!!";
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try {
            RandomAccessFile file = new RandomAccessFile(new File(fileName), "rw");
            long lenFile = file.length();
            if(number<lenFile){
                file.seek(number);
            }else {
                file.seek(lenFile);
            }

            file.write(text.getBytes());
        }catch (FileNotFoundException e){
            System.out.println("file not found "+ e.getMessage());
        }catch (IOException e1){
            System.out.println(e1.getMessage());
        }



    }
}
