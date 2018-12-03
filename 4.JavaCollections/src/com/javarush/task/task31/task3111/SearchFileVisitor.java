package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        //boolean mustAd = true;
        if(minSize != 0 && content.length < minSize){
            //System.out.println("false1 " + file.getFileName().toString());
            return super.visitFile(file, attrs);
        }
        if(maxSize != 0 && content.length > maxSize){
            //System.out.println("false2 " + file.getFileName().toString());
            return super.visitFile(file, attrs);
        }
        if(partOfName != null && !file.getFileName().toString().contains(partOfName)){
            //System.out.println("false3 " + file.getFileName().toString());
            return super.visitFile(file, attrs);
        }
        if(partOfContent != null){
            boolean hasString = false;
            List<String> list = Files.readAllLines(file);
            for (String s : list){
                if(s.contains(partOfContent)){
                    hasString = true;
                    break;
                }
            }
            if (!hasString){
                //System.out.println("false4 " + file.getFileName().toString());
                return super.visitFile(file, attrs);
            }

        }
        //System.out.println("try to add "  + file.getFileName().toString());
        foundFiles.add(file);
        //System.out.println("Add a "  + file.getFileName().toString());
        return super.visitFile(file, attrs);
    }



    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }
    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
