package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by DIMA on 19.12.2017.
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public SubscriptAction() {
        super("Подстрочный знак");
    }
}
