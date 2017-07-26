package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        while (bufferedReader.ready()){
            String[] data = bufferedReader.readLine().split(" ");
            int year = Integer.parseInt(data[data.length-1]);
            int month = Integer.parseInt(data[data.length-2]);
            int day = Integer.parseInt(data[data.length-3]);
            String name = "";
            for(int i = 0; i<data.length-3; i++){
                name = name + " " + data[i];
            }
            name = name.substring(1);
            //System.out.println("print---------- " + name + " " + day + " " + month + " " + year);

            GregorianCalendar c = new GregorianCalendar();
            c.set(year, month-1, day);
            c.set(Calendar.HOUR_OF_DAY, 0);
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDay = c.getTime();
            //System.out.println(birthDay.toString());
            PEOPLE.add(new Person(name, birthDay));

        }
        //for(Person p : PEOPLE){            System.out.println(p.getName() + " " + p.getBirthday().toString());        }
        bufferedReader.close();


    }
}
