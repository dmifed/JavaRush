package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by DIMA on 17.01.2018.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException{
        this.tablet = tablet;
        initDishes();
        //dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if(dishes.size() == 0){
            return "";
        }else {
            return "Your order: " + dishes + " of " + tablet;
        }
    }

    public int getTotalCookingTime(){
        int durationAllDishes = 0;
        for (Dish d: dishes){
            durationAllDishes = durationAllDishes + d.getDuration();
        }
        return durationAllDishes;
    }

    public boolean isEmpty(){        return dishes.isEmpty();    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException{
        //System.out.println("Order.initDishes");
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
