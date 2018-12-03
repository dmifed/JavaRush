package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIMA on 08.02.2018.
 */
public class TestOrder extends Order {
    //protected List<Dish> dishes;
    //private final Tablet tablet;
    public TestOrder(Tablet tablet) throws IOException{
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        this.dishes = new ArrayList<>();
        int sizeOfDishList = (int) (Math.random()*Dish.values().length);
        if (sizeOfDishList == 0){
            sizeOfDishList = 1;
        }
        //System.out.println("TestOrder.initDishes " + dishes);
        for(int i = 0; i< sizeOfDishList; i++){
            int numsOfDish = (int)(Math.random()*Dish.values().length);
            //System.out.println(Dish.values().length + " " + Dish.values()[3]);
            dishes.add(Dish.values()[numsOfDish]);
        }
    }
}
