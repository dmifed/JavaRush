package com.javarush.task.task20.task2014;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

        System.out.println(new Solution(4));
        String fileName = "X:\\Programming\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\t.txt";
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Solution savedObject = new Solution(5);
            objectOutputStream.writeObject(savedObject);
            Solution s = new Solution(55);
            Solution loadedObject = (Solution) objectInputStream.readObject();
            //System.out.println("load done!");
            System.out.println(savedObject.string.equals(loadedObject.string));

        }catch (IOException e){
            System.out.println("IOExeption " + e);
        }
        catch (ClassNotFoundException e2){
            System.out.println("ClassNotFoundException " + e2);
        }


    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    /*
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.write(temperature);
            out.writeObject(string);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            temperature = in.readInt();
            string = (String) in.readObject();
        }
    */
    @Override
    public String toString() {
        return this.string;
    }

}
