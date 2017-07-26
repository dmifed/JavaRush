package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws Exception {

        //parsing args[]
        String productName = "";
        String quantity = args[args.length-1];
        String price = args[args.length-2];
        for(int i=1; i<args.length-2; i++){
            productName = productName + args[i] + " ";
        }
        productName = productName.substring(0,productName.length()-1);

        //Setting size
        byte[] quantityBytes = new byte[4];
        quantityBytes = getArrayOfSpases(quantityBytes);
        quantityBytes = copyInfoToArray(quantity.getBytes(), quantityBytes);
        //for(byte b : quantityBytes){            System.out.print(b + " ");        } System.out.println();// TEMP

        byte[] priceBytes = new byte[8];
        priceBytes = getArrayOfSpases(priceBytes);
        priceBytes = copyInfoToArray(price.getBytes(), priceBytes);
        //for(byte b : priceBytes){            System.out.print(b + " ");        } System.out.println();// TEMP

        char[] productNameChars = new char[30];
        productNameChars = getArrayOfSpases(productNameChars);
        productNameChars = copyInfoToArray(productName.toCharArray(), productNameChars);
        //for(char b : productNameChars){            System.out.print(b);        } System.out.println();// TEMP

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(filename));
        //list of id
        String line = "";
        ArrayList<Integer> lst = new ArrayList<Integer>();
        while((line=reader2.readLine())!=null){
            //System.out.println("line " + line);
            String idString = line.substring(0,8);
            int endId = 8;
            char[] idCharArray = idString.toCharArray();
            for(int i=0; i<idCharArray.length; i++){
                if(idCharArray[i] == ' '){
                    endId = i;
                    break;
                }
            }
            idString = idString.substring(0,endId);
            int id = Integer.parseInt(idString);
            lst.add(id);
        }
        reader2.close();
        int maxId = 0;
        for(int i=0; i<lst.size(); i++){
            if (lst.get(i)>maxId){
                maxId = lst.get(i);
            }
        }
        int newId = maxId+1;
        byte[] idBytes = new byte[8];
        idBytes = getArrayOfSpases(idBytes);
        idBytes = copyInfoToArray(String.valueOf(newId).getBytes(), idBytes);
        //for(byte b : idBytes){            System.out.print(b + " ");        } System.out.println();// TEMP

        FileOutputStream outputStream = new FileOutputStream(filename, true);
        //outputStream.write(10);
        outputStream.write(idBytes);
        outputStream.close();
        FileWriter fileWriter = new FileWriter(filename,true);
        fileWriter.write(productNameChars);
        fileWriter.close();
        FileOutputStream outputStream1 = new FileOutputStream(filename, true);
        outputStream1.write(priceBytes);
        outputStream1.write(quantityBytes);
        outputStream1.close();





    }
    //get array of spaces
    private static byte[] getArrayOfSpases(byte[] b){
        for(int i = 0; i<b.length; i++){            b[i] = 32;        }
        return b;
    }
    //copy info to array
    private static byte[] copyInfoToArray(byte[] from, byte[] to){
        for(int i = 0; i<from.length; i++){            to[i] = from[i];        }
        return to;
    }
    //get array of spaces
    private static char[] getArrayOfSpases(char[] b){
        for(int i = 0; i<b.length; i++){            b[i] = ' ';        }
        return b;
    }
    //copy info to array
    private static char[] copyInfoToArray(char[] from, char[] to){
        for(int i = 0; i<from.length; i++){            to[i] = from[i];        }
        return to;
    }




}
