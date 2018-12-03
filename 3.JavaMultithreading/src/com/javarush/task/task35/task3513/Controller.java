package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by DIMA on 08.05.2018.
 */
public class Controller extends KeyAdapter{
    private Model model;
    private View view;

    private static int WINNING_TILE = 2048;

    //Для начала нам понадобится конструктор, он будет принимать один параметр типа Model,
    // инициализировать поле model, а также сохранять в поле view новый объект
    // типа View с текущим контроллером(this) в качестве параметра конструктора.
    public Controller(Model model){
        this.model = model;
        view = new View(this);
    }

    //Далее, нам нужен метод resetGame, который позволит вернуть игровое поле в начальное состояние.
    // Необходимо обнулить счет, установить флаги isGameWon и isGameLost у представления в false
    // и вызывать метод resetGameTiles у модели.
    // Примечание: устанавливай значение полей напрямую, без использования сеттеров.

    public void resetGame(){
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }



    public Tile[][] getGameTiles(){
        return model.getGameTiles();
    }

    public int getScore(){
        return model.score;
    }

    //1. Если была нажата клавиша ESC - вызови метод resetGame.
    //2. Если метод canMove модели возвращает false - установи флаг isGameLost в true.
    //3. Если оба флага isGameLost и isGameWon равны false - обработай варианты движения:
        //а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;
        //б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;
        //в) для клавиши KeyEvent.VK_UP вызови метод up у модели;
        //г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.
    //4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.
    //5. В самом конце, вызови метод repaint у view.
    //P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int keyCode = e.getKeyCode();
        if(keyCode == 0x1B){
            resetGame();
        }else if(!model.canMove()){
            view.isGameLost = true;
        }else if((!view.isGameLost) && (!view.isGameWon)){
            switch (keyCode){
                case 0x25 : model.left();
                    break;
                case 0x26 : model.up();
                    break;
                case 0x27 : model.right();
                    break;
                case 0x28 : model.down();
                    break;
                case KeyEvent.VK_Z : model.rollback();
                    break;
                case KeyEvent.VK_R : model.randomMove();
                    break;
                case KeyEvent.VK_A : model.autoMove();
                    break;
            }
            if (model.maxTile == WINNING_TILE){
                view.isGameWon = true;
            }
        }
        view.repaint();
    }

    public View getView() {
        return view;
    }
}
