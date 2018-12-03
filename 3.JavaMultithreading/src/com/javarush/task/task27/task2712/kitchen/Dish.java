package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by DIMA on 17.01.2018.
 */
public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration){
        this.duration = duration;
    }
    public static String allDishesToString(){
        return Dish.Fish + ", " + Dish.Steak + ", " + Dish.Soup + ", " + Dish.Juice + ", " + Dish.Water;
    }

    public int getDuration() {        return duration;    }
}
