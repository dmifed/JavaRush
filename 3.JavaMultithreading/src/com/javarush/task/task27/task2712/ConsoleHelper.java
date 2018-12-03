package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 17.01.2018.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    static String readString() throws IOException{
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException{
        writeMessage("Please input dishes");
        writeMessage(Dish.allDishesToString());
        List<Dish> dishList = new ArrayList<>();
        String dish = "";
        while (!(dish = readString()).equals("exit")){
            if(Dish.allDishesToString().contains(dish)){
                dishList.add(Dish.valueOf(dish));
            }else {
                writeMessage("Sorry, we haven't this dish in our menu");
                writeMessage(Dish.allDishesToString());
            }
        }
        return dishList;
    }
}
