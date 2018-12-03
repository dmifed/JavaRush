package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String pathToFile = args[0]; //original
        String pathToZip = args[1]; //original

        //String pathToZip = "E:\\test31Level\\zipTest\\zipTest.zip"; //test
        //String pathToFile = "E:\\test31Level\\zipTest\\Add.txt"; //test
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathToZip)); //считываем из zip
        ZipOutputStream zipOutputStream;
        Map<ZipEntry, byte[]> zipEntryMap = new HashMap<>();
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null){
            byte[] bytes;
            // записать содержимое в байтовый массив
            if(!zipEntry.isDirectory()){
                //String filename = zipEntry.getName();
                bytes = new byte[(int)zipEntry.getSize()];
                zipInputStream.read(bytes);
                zipEntryMap.put(zipEntry, bytes);
                zipInputStream.closeEntry();
            }else {
                zipEntryMap.put(zipEntry, null);
                zipInputStream.closeEntry();
            }
        }
        zipOutputStream = new ZipOutputStream(new FileOutputStream(pathToZip));
        // из мапы переписываем все в зипоутпутстрим
        File file = new File(pathToFile);
        String fileName = file.getName();
        //boolean putAdd = false;
        for(Map.Entry<ZipEntry, byte[]> entry : zipEntryMap.entrySet()){
            ZipEntry z = new ZipEntry(entry.getKey().getName());
            //System.out.println(z.isDirectory() + " " + z.getName() + " " + fileName);
            // проверить есть ли такой же файл то переписать его
            if(!z.isDirectory() && z.getName().equals(fileName)){
                //System.out.println("copy new file in new// " + fileName);
                FileInputStream fileInputStream = new FileInputStream(pathToFile);
                byte[] bytesToWrite = new byte[fileInputStream.available()];
                fileInputStream.read(bytesToWrite);
                zipOutputStream.putNextEntry(new ZipEntry(z));
                zipOutputStream.write(bytesToWrite);
                zipOutputStream.closeEntry();
                //putAdd = true;
            }
            if(!z.isDirectory() && !z.getName().equals(fileName)){
                //System.out.println("write file " + z);
                byte[] bytesToWrite = entry.getValue();
                zipOutputStream.putNextEntry(new ZipEntry(z));
                //System.out.println("put " + z + " done. Try to write " + printByteArr(bytesToWrite) + " size " + bytesToWrite.length);
                zipOutputStream.write(bytesToWrite);
                zipOutputStream.closeEntry();
            }
        }
            //System.out.println("create inputstream " + pathToFile);
            //FileInputStream fileInputStream = new FileInputStream(pathToFile);
            //byte[] bytesToWrite = new byte[fileInputStream.available()];
            //fileInputStream.read(bytesToWrite);
            String pathToFileZip = Paths.get(pathToFile).getFileName().toString();
            zipOutputStream.putNextEntry(new ZipEntry("new\\" + pathToFileZip));
            Files.copy(Paths.get(pathToFile), zipOutputStream);
            //zipOutputStream.write(bytesToWrite);
            zipOutputStream.closeEntry();

        //Files.copy(Paths.get(pathToZip), zipOutputStream);
        zipInputStream.close();
        zipOutputStream.close();


    }
    /*
    public static String printByteArr(byte[] bytes){
        String s = "";
        for(byte b : bytes){
            s += (char) b;
        }
        return s;
    }
    */
}
