package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by DIMA on 08.05.2018.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model(){
        resetGameTiles();

    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    boolean canMove(){
        if(getEmptyTiles().size()>0){
            return true;
        }
        //check left and right equals value
        for(int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length-1; j++){
                if(gameTiles[i][j].value == gameTiles[i][j+1].value){
                    return true;
                }
            }
        }
        //check up and down equals value
        for(int i = 0; i < gameTiles.length-1; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                if(gameTiles[i][j].value == gameTiles[i+1][j].value){
                    return true;
                }
            }
        }

        return false;
    }

    protected void resetGameTiles(){
        score = 0;
        maxTile = 0;
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i = 0; i<gameTiles.length; i++){
            for(int j = 0; j<gameTiles[i].length; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile(){
        if(getEmptyTiles().size() > 0){
            Tile tile = getEmptyTiles().get((int)(Math.random()*getEmptyTiles().size()));
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }

    }

    private List<Tile> getEmptyTiles(){
        List<Tile> tileList = new ArrayList<>();
        for(int i = 0; i<gameTiles.length; i++){
            for(int j = 0; j<gameTiles[i].length; j++){
                if(gameTiles[i][j].isEmpty()){
                    tileList.add(gameTiles[i][j]);
                }
            }
        }
        return tileList;
    }

    private boolean compressTiles(Tile[] tiles){
        //ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
        boolean hasBeenChanged = false;
        for(int count = 0 ; count < tiles.length; count++){
            for (int i = tiles.length-1; i > 0; i--){
                if(tiles[i].value != 0 && tiles[i-1].value == 0){
                    hasBeenChanged = true;
                    Tile tmp = tiles[i-1];
                    tiles[i-1] = tiles[i];
                    tiles[i] = tmp;
                }
            }
        }
        return hasBeenChanged;
    }

    private boolean mergeTiles(Tile[] tiles){
        //ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}
        boolean hasBeenChanged = false;
        for (int i = 0; i < tiles.length-1; i++){
            if((tiles[i].value == tiles[i+1].value) && (tiles[i].value != 0)){
                hasBeenChanged = true;
                int v = tiles[i].value;
                tiles[i] = new Tile(v*2);
                score += v*2;
                if(v*2 > maxTile){
                    maxTile = v*2;
                }
                tiles[i+1] = new Tile();
                compressTiles(tiles);
            }
        }
        return hasBeenChanged;
    }

    void left(){
        if(isSaveNeeded){
            saveState(gameTiles);
        }
        boolean needToAddTile = false;
        for(int i = 0; i<gameTiles.length; i++){
            boolean hasBeenCompressed = compressTiles(gameTiles[i]);
            boolean hasBeenMerge = mergeTiles(gameTiles[i]);
            if (hasBeenCompressed || hasBeenMerge){
                needToAddTile = true;
            }
        }
        if(needToAddTile){
            addTile();
        }
        isSaveNeeded = true;
    }

    void right(){
        saveState(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        left();
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
    }

    void up(){
        saveState(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        left();
        gameTiles = rotateArrayClockwise90(gameTiles);
    }

    void down(){
        saveState(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        left();
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
        gameTiles = rotateArrayClockwise90(gameTiles);
    }

    private Tile[][] rotateArrayClockwise90(Tile[][] arr){
        Tile[][] tmpArray = new Tile[arr.length][arr.length];
        for(int row = 0; row<tmpArray.length; row++){
            for (int col = 0; col<tmpArray[row].length; col++){
                tmpArray[row][col] = arr[arr.length-1-col][row];
            }
        }
        return tmpArray;
    }

    private void saveState(Tile[][] arr){
        Tile[][] prevTile = new Tile[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for (int j = 0 ; j < arr[i].length; j++){
                Tile tile = new Tile(arr[i][j].value);
                prevTile[i][j] = tile;
            }
        }
        previousStates.push(prevTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if((!previousScores.empty()) && (!previousStates.empty())){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }

    }

    //Начнем с простого, реализуем метод randomMove в классе Model,
    // который будет вызывать один из методов движения случайным образом.
    // Можешь реализовать это вычислив целочисленное n = ((int) (Math.random() * 100)) % 4.
    //Это число будет содержать целое псевдослучайное число в диапазоне [0..3],
    // по каждому из которых можешь вызывать один из методов left, right, up, down.
    //Не забудь добавить в метод keyPressed класса Controller вызов метода
    // randomMove по нажатию на клавишу R (код - KeyEvent.VK_R).

    void randomMove(){
        int n = ((int)(Math.random()*100)) % 4;
        switch (n){
            case 0 : left();
                break;
            case 1 : up();
                break;
            case 2 : right();
                break;
            case 3 : down();
                break;
        }
    }

    //boolean hasBoardChanged - будет возвращать true, в случае, если вес плиток в массиве gameTiles
    // отличается от веса плиток в верхнем массиве стека previousStates. Обрати внимание на то,
    // что мы не должны удалять из стека верхний элемент, используй метод peek.

    public boolean hasBoardChanged(){
        Tile[][] prevStep = previousStates.peek();
        int currentWeight = 0;
        int prevWeight = 0;
        for(int i = 0; i<gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                currentWeight += gameTiles[i][j].value;
                prevWeight += prevStep[i][j].value;
            }
        }
        return currentWeight != prevWeight;
    }

    //2) MoveEfficiency getMoveEfficiency(Move move) - принимает один параметр типа move,
    // и возвращает объект типа MoveEfficiency описывающий эффективность переданного хода.
    // Несколько советов:
    //а) не забудь вызывать метод rollback, чтобы восстановить корректное игровое состояние;
    //б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток
    // и счет у объекта MoveEfficiency сделай равными -1 и 0 соответственно;
    //в) выполнить ход можно вызвав метод move на объекте полученном в качестве параметра.

    public MoveEfficiency getMoveEfficiency(Move move){
        move.move();
        MoveEfficiency moveEfficiency;
        //MoveEfficiency(int numberOfEmptyTiles, int score, Move move)
        if(!isSaveNeeded){
            System.out.println("-1");
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this :: left));
        priorityQueue.offer(getMoveEfficiency(this :: right));
        priorityQueue.offer(getMoveEfficiency(this :: up));
        priorityQueue.offer(getMoveEfficiency(this :: down));
        MoveEfficiency efficiency = priorityQueue.peek();
        Move move = efficiency.getMove();
        move.move();
    }



}
