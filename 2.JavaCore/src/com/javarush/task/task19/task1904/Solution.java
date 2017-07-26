package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }
        //Иванов Иван Иванович 31 12 1950
        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] fields = line.split(" ");
            String firstName = fields[1];
            String lastName = fields[0];
            String middleName = fields[2];
            int day = Integer.parseInt(fields[3]);
            int month = Integer.parseInt(fields[4]);
            int year = Integer.parseInt(fields[5]);
            Calendar cal = new GregorianCalendar(year, month-1, day);
            Date date = cal.getTime();
            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
