package com.javarush.task.task32.task3210;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        //В метод main приходят три параметра:
        //1) fileName - путь к файлу;
        //2) number - число, позиция в файле;
        //3) text - текст.

        //Считать текст с файла начиная с позиции number, длинной такой же как и длинна переданного текста в третьем параметре.
        //Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
        //Используй RandomAccessFile и его методы seek(long pos), read(byte b[], int off, int len), write(byte b[]).
        //Используй один из конструкторов класса String для конвертации считанной строчки в текст.

        //String fileName = "E:\\JavaRushTests\\test32level\\long.txt";
        //int number = 5;
        //String text = "MMMM";
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        int lenToRead = text.getBytes().length;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
            randomAccessFile.seek(number);
            byte[] bytesInFile = new byte[lenToRead];
            randomAccessFile.read(bytesInFile, 0, lenToRead);
            String textInFile = new String(bytesInFile);
            randomAccessFile.seek(randomAccessFile.length());
            if(textInFile.equals(text)){
                randomAccessFile.write("true".getBytes());
            }else {
                randomAccessFile.write("false".getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found " + e.getMessage());
        }catch (IOException e1){
            System.out.println(e1.getMessage());
        }
    }
}
