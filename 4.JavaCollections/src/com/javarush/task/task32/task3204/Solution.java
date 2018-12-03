package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());

    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        List<String> characterList = new ArrayList<>();
        String[] allLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        int len = allLetters.length;
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowCase = false;
        while (!(hasDigit && hasLowCase && hasUpperCase)){
            hasDigit = false;
            hasUpperCase = false;
            hasLowCase = false;
            characterList = new ArrayList<>();
            for(int i = 0; i < 8; i++){
                characterList.add(allLetters[(int)(Math.random()*len)]);
            }

            for(String s : characterList){
                if(s.matches("[A-Z]")){                hasUpperCase = true;            }
                if (s.matches("[a-z]")){                hasLowCase = true;            }
                if(s.matches("[0-9]")){                hasDigit = true;            }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String s : characterList){
            sb.append(s);
        }
        try{
            byteArrayOutputStream.write(sb.toString().getBytes());
        }catch (IOException e){
            System.out.println("IO " + e.getMessage());
        }
        return byteArrayOutputStream;
    }
}