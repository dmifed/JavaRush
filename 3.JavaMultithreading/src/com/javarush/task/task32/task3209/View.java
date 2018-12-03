package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
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
    private UndoManager undoManager = new UndoManager(); //устанавливает количество возможных undo/redo
    private UndoListener undoListener = new UndoListener(undoManager);
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

    public View(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    //метод наследуется от интерфейса ActionListener
    //вызвается при выборе пунктов меню, у которых представление указано в виде слушателя событий.
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "Новый": controller.createNewDocument();
                break;
            case "Открыть": controller.openDocument();
                break;
            case "Сохранить": controller.saveDocument();
                break;
            case "Сохранить как...": controller.saveDocumentAs();
                break;
            case "Выход": controller.exit();
                break;
            case "О программе": showAbout();
                break;
        }
    }


    // Выбирает html вкладку (переключается на нее). Сбрасывает все правки
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    //получает документ у контроллера и устанавливает его в панель редактирования htmlTextPane
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }

    //сбрасывает все правки в менеджере undoManager
    public void resetUndo(){
        undoManager.discardAllEdits();
    }
    //отменяет последнее действие
    public void undo(){
        try {
            undoManager.undo();
        }catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }
    //возвращает последнее отмененное действие
    public void redo(){
        try {
            undoManager.redo();
        }catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
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

    // показывает диалоговое окно с информацией о программе
    //тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE
    public void showAbout(){
        JOptionPane jOptionPane = new JOptionPane();
        JOptionPane.showMessageDialog(jOptionPane, "Version 0", "About", JOptionPane.INFORMATION_MESSAGE);
        tabbedPane.add(jOptionPane);
        jOptionPane.setVisible(true);
    }

    //вызывается, когда произошла смена выбранной вкладки.
    public void selectedTabChanged(){
        int index = tabbedPane.getSelectedIndex();
        if(index == 0){ //html
            controller.setPlainText(plainTextPane.getText());
        }
        if(index == 1){ //text
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void exit(){
        controller.exit();
    }

    public Controller getController() {        return controller;    }
    public void setController(Controller controller) {        this.controller = controller;    }
    public UndoListener getUndoListener() {
        return undoListener;
    }


}
