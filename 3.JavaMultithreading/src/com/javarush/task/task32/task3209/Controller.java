package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

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

    public HTMLDocument getDocument() {
        return document;
    }

    //инициализация контроллера
    public void init(){
        createNewDocument();
    }

    //сбрасывает текущий документ
    public void resetDocument(){
        if(document != null){
            document.removeUndoableEditListener(view.getUndoListener());
            document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
        }
        view.update();
    }
    //записывать переданный текст с html тегами в документ document
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try{
            htmlEditorKit.read(stringReader, document, 0);
        }catch (IOException e){
            ExceptionHandler.log(e);
        }catch (BadLocationException eb){
            ExceptionHandler.log(eb);
        }
    }
    //получать текст из документа со всеми html тегами.
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try{
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        }catch (IOException e){
            ExceptionHandler.log(e);
        }catch (BadLocationException eb){
            ExceptionHandler.log(eb);
        }
        return stringWriter.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }
    /*
    Когда файл выбран, необходимо:
    23.2.1. Установить новое значение currentFile.
    23.2.2. Сбросить документ.
    23.2.3. Установить имя файла в заголовок у представления.
    23.2.4. Создать FileReader, используя currentFile.
    23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
    23.2.6. Сбросить правки (вызвать метод resetUndo представления).
    23.2.7. Если возникнут исключения - залогируй их и не пробрасывай наружу.
     */
    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int choose = jFileChooser.showOpenDialog(view);
        if(choose == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)){
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText().
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader, document, 0);
                view.resetUndo();
            }catch (IOException ioe){
                ExceptionHandler.log(ioe);
            }catch (BadLocationException ble){
                ExceptionHandler.log(ble);
            }

        }

    }

    //Метод должен работать также, как saveDocumentAs(),
    //но не запрашивать файл у пользователя, а использовать currentFile.
    //Если currentFile равен null, то вызывать метод saveDocumentAs().
    public void saveDocument(){
        view.selectHtmlTab();
        if(currentFile == null){
            saveDocumentAs();
        }else {
            view.setTitle(currentFile.getName()); //Устанавливать имя файла в качестве заголовка окна представления.
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText().
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            }catch (IOException ioe){
                ExceptionHandler.log(ioe);
            }catch (BadLocationException ble){
                ExceptionHandler.log(ble);
            }
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter()); //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        //jFileChooser.addChoosableFileFilter(new HTMLFileFilter());
        int choose = jFileChooser.showSaveDialog(view); //Показывать диалоговое окно "Save File" для выбора файла
        if(choose == JFileChooser.APPROVE_OPTION){ //Если пользователь подтвердит выбор файла
            currentFile = jFileChooser.getSelectedFile(); //Сохранять выбранный файл в поле currentFile.
            view.setTitle(currentFile.getName()); //Устанавливать имя файла в качестве заголовка окна представления.
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                //Переписывать данные из документа document в объекта FileWriter-а аналогично тому, как мы это делали в методе getPlainText().
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            }catch (IOException ioe){
                ExceptionHandler.log(ioe);
            }catch (BadLocationException ble){
                ExceptionHandler.log(ble);
            }

        }

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
