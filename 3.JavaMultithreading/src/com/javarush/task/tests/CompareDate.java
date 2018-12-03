package com.javarush.task.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by DIMA on 17.02.2018.
 */
public class CompareDate {
    public static void main(String[] args) throws Exception {
        Date d1 = new Date();
        Thread.sleep(1);
        Date d2 = new Date();
        System.out.println(d2.equals(d1));

        CompareDate cd = new CompareDate();
        System.out.println(cd.timeToZero(d1).equals(cd.timeToZero(d2)));



    }

    private Date timeToZero(Date d){
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}
