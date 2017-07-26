package com.javarush.task.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by dima on 01.06.2017.
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
        System.out.println(d);
        System.out.println(s.format(d));

    }
}
