package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DIMA on 14.12.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;

    private JTabbedPane tabbedPane = new JTabbedPane(); //панель с двумя вкладками.
    private JTextPane htmlTextPane = new JTextPane(); //компонент для визуального редактирования html. Размещен на первой вкладке.
    private JEditorPane plainTextPane = new JEditorPane(); //компонент для редактирования html в виде текста (теги и их содержимое).

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public View(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    //инициализация представления.
    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    //инициализация меню
    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar(); //панель меню
        //Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    //инициализация панелей редактора
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane1 = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", jScrollPane1);
        JScrollPane jScrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane2);
        tabbedPane.setPreferredSize(new Dimension(500, 500));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    //инициализация графического интерфейса
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public void selectedTabChanged(){}

    public void exit(){
        controller.exit();
    }

    public Controller getController() {        return controller;    }
    public void setController(Controller controller) {        this.controller = controller;    }

    public boolean canUndo(){
        return false;
    }

    public boolean canRedo(){
        return false;
    }
}
