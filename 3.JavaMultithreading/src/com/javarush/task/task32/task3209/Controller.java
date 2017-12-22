package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 * Created by DIMA on 14.12.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view){
        this.view = view;
    }

    //инициализация контроллера
    public void init(){
    }

    public void exit(){
        System.exit(0);
    }

    /*
    2.2.1. Создавать объект представления.
    2.2.2. Создавать контроллер, используя представление.
    2.2.3. Устанавливать у представления контроллер.
    2.2.4. Инициализировать представление.
    2.2.5. Инициализировать контроллер. Контроллер должен инициализироваться после представления.
     */
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }
}
