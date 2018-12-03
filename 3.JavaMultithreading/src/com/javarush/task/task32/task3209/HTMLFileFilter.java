package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by DIMA on 16.01.2018.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String fileName = file.getName();
        fileName = fileName.toLowerCase();
        return fileName.endsWith(".html") || fileName.endsWith(".htm") || file.isDirectory();
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
