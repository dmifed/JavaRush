package com.javarush.task.task20.task2020;



import java.io.*;
import java.util.logging.Logger;

/*
Сериализуйте Person
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception{
        //Solution solution = new Solution();
        Sex sex = Sex.FEMALE;
        Person person = new Person("First", "Last", "Country", sex);
        String fileName = "X:\\Programming\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2020\\test.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person loadedPerson = (Person)objectInputStream.readObject();
        System.out.println(loadedPerson.firstName + " " + loadedPerson.lastName + " " + loadedPerson.fullName);
        System.out.println(loadedPerson.country + " " + loadedPerson.greetingString + " " + loadedPerson.sex);
        System.out.println(loadedPerson.logger + " " + loadedPerson.outputStream);

    }
}
