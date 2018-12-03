package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    Entry<String> root;
    private List<Entry<String>> treeList = new ArrayList<>();
    //возвращает текущее количество элементов в дереве
    @Override
    public int size(){
        return treeList.size()-1;
    }
    public CustomTree(){
        root = new Entry<>("root");
        root.lineNumber = 0;
        treeList.add(root);
    }

    //возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public String getParent(String s){
        //Entry<String> parent = null;
        if(treeList.get(0).elementName.equals(s)){            return s + " is a name of root. No parent";        }
        for(int i = 1; i<treeList.size(); i++){
            Entry<String> entry = treeList.get(i);
            if(entry.elementName.equals(s)){
                if(entry.parent.lineNumber == 0){
                    return null;
                }else {
                    return entry.parent.elementName;
                }

            }
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        boolean deleted = false;
        String s;
        try{
            s = (String) o;
        }catch (ClassCastException e){
            throw new UnsupportedOperationException();
        }
        deleted = removeElementAndItsChild(s);

        //check a possible to add a child and repair if it need
        boolean needToRepair = true;
        for (Entry<String> entry : treeList){
            if(entry.isAvailableToAddChildren()){
                needToRepair = false;
                break;
            }
        }
        if(needToRepair){
            //need to define an entry to repair
            int maxLevel = 0;
            for(Entry<String> entry : treeList){
                if(entry.lineNumber > maxLevel){
                    maxLevel = entry.lineNumber;
                }
            }
            for(Entry<String> entry : treeList){
                if(entry.lineNumber == maxLevel){
                    //System.out.println("repairing " + treeList.get(i).elementName);
                    entry.availableToAddLeftChildren = true;
                    entry.availableToAddRightChildren = true;
                    entry.leftChild = null;
                    entry.rightChild = null;
                }

            }
        }
        //testPrint();
        return deleted;
    }

    //for remove
    private boolean removeElementAndItsChild(String s){
        for (int i = 0; i<treeList.size(); i++){
            if(treeList.get(i).elementName.equals(s)){
                if(treeList.get(i).leftChild == null && treeList.get(i).rightChild == null){ //parent has not a children
                    treeList.remove(i);
                }else if(treeList.get(i).rightChild == null){ // parent has only left child
                    Entry<String> leftChild = treeList.get(i).leftChild;
                    treeList.remove(i);
                    removeElementAndItsChild(leftChild.elementName);

                }else { //parent has a left and right children
                    Entry<String> leftChild = treeList.get(i).leftChild;
                    Entry<String> rightChild = treeList.get(i).rightChild;
                    treeList.remove(i);
                    removeElementAndItsChild(leftChild.elementName);
                    removeElementAndItsChild(rightChild.elementName);
                }
                return true;
            }
        }
        return false;

        //System.out.print(" nulling "+ s + " ");
    }

    //добавляет элементы дерева, в качестве параметра принимает имя элемента (elementName),
    //искать место для вставки начинаем слева направо.
    @Override
    public boolean add(String s) {
        Entry<String> entry = new Entry<>(s);
            //search in treeList a entry which can add a child
        for(Entry<String> entryInList : treeList){
            if(entryInList.isAvailableToAddChildren()){
                addingChild(entryInList, entry);
                entry.lineNumber = entryInList.lineNumber + 1;
                treeList.add(entry);
                entry.parent = entryInList;
                entryInList.checkChildren();
                entry.checkChildren();
                return true;
            }
        }
        return false;
    }
    private void addingChild(Entry<String> entryInList, Entry<String> entry){
        if(entryInList.availableToAddLeftChildren){
            entryInList.leftChild = entry;
        }else {
            entryInList.rightChild = entry;
        }
    }

    private void testPrint(){
        for (Entry<String> entry : treeList){
            System.out.print(" " + entry.elementName + " ");
        }
        System.out.println();
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String s){
            elementName = s;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren(){
            if(leftChild != null){                availableToAddLeftChildren = false;            }
            if (rightChild != null){                availableToAddRightChildren = false;            }
        }
        public boolean isAvailableToAddChildren(){return availableToAddLeftChildren || availableToAddRightChildren;}
    }
    // ALL throw new UnsupportedOperationException()
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }
    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }
}
