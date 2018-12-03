package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        //String[] subArchiveNames = Arrays.copyOfRange(args, 1, args.length); //original
        String resultFileName = "E:\\test31Level\\zipTest\\v1.avi"; //test
        String s1 = "E:\\test31Level\\zipTest\\video.zip.001"; //test
        String s2 = "E:\\test31Level\\zipTest\\video.zip.003";//test
        String s3 = "E:\\test31Level\\zipTest\\video.zip.004";//test
        String s4 = "E:\\test31Level\\zipTest\\video.zip.002";//test
        String s5 = "E:\\test31Level\\zipTest\\video.zip.005";//test
        String[] subArchiveNames = {s1, s2, s3, s4, s5}; //test
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(resultFileName);
        }catch (FileNotFoundException e){
                System.out.println("file not found " + e.getMessage());
        }
        List<InputStream> inputStreamList;
        SequenceInputStream sequenceInputStream;
        ZipInputStream zipInputStream;

        /*
        String resultFileName = "E:\\test31Level\\zipTest\\v1.avi"; //test
        String s1 = "E:\\test31Level\\zipTest\\video.zip.001"; //test
        String s2 = "E:\\test31Level\\zipTest\\video.zip.003";//test
        String s3 = "E:\\test31Level\\zipTest\\video.zip.004";//test
        String s4 = "E:\\test31Level\\zipTest\\video.zip.002";//test
        String s5 = "E:\\test31Level\\zipTest\\video.zip.005";//test
        String[] subArchiveNames = {s1, s2, s3, s4, s5}; //test
        */
        /*
        String resultFileName = "E:\\test31Level\\zipTest\\Adddd.txt"; //test
        String s1 = "E:\\test31Level\\zipTest\\Add.zip.001"; //test
        String s2 = "E:\\test31Level\\zipTest\\Add.zip.003";//test
        String s3 = "E:\\test31Level\\zipTest\\Add.zip.002";//test
        String[] subArchiveNames = {s1, s2, s3}; //test
        */
        Collections.sort(Arrays.asList(subArchiveNames), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] pathsOfO1 = o1.split("\\.");
                String numO1 = pathsOfO1[pathsOfO1.length-1];
                String[] pathsOfO2 = o2.split("\\.");
                String numO2 = pathsOfO2[pathsOfO2.length-1];
                return numO1.compareTo(numO2);
            }
        });

        try{
            inputStreamList = new ArrayList<>();
            for(String s : subArchiveNames){
                InputStream inputStream = new FileInputStream(s);
                inputStreamList.add(inputStream);
                //inputStream.close();
            }
            sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStreamList));
            zipInputStream = new ZipInputStream(sequenceInputStream);
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            //zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
            int countBytes;
            byte[] bytes = new byte[1024];
            while ((countBytes = zipInputStream.read(bytes)) > 0){
                //System.out.println(countBytes);
                fileOutputStream.write(bytes, 0, countBytes);
                fileOutputStream.flush();
                //System.out.println(countBytes + " " + toStringByteArray(bytes));
            }
            //zipOutputStream.closeEntry();
            zipInputStream.closeEntry();
            fileOutputStream.close();
            sequenceInputStream.close();
            zipInputStream.close();

        }catch (IOException e1){
            System.out.println("ioExeption " + e1.getMessage());
        }
    }
    /*
    public static String toStringByteArray(byte[] bytes){
        String s = "";
        for(byte b : bytes){
            s += (char) b;
        }
        s += "\n";
        return s;
    }
    */

}
