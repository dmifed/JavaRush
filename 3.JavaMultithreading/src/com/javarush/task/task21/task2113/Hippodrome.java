package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 21.04.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> l){
        horses = l;
    }

    void run(){
        for (int i = 0; i<100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){                System.out.println(e);            }


        }
    }
    void print(){}
    void move(){}

    public static void main(String[] args) {
        Horse marta = new Horse("Marta", 3, 0);
        Horse klava = new Horse("Klava", 3, 0);
        Horse jack = new Horse("Jack", 3, 0);
        game = new Hippodrome(new ArrayList<>());
        List<Horse> horses = game.getHorses();
        horses.add(marta);
        horses.add(klava);
        horses.add(jack);
    }
}
