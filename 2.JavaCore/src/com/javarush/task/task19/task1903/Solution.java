package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {

    }
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
        //System.out.println(countries.get("UA"));
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){            this.data = data;        }

        @Override
        public String getCompanyName() {            return data.getCompany();        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            String phoneNumber = String.valueOf(data.getPhoneNumber());
            String phoneCode = "+" + String.valueOf(data.getCountryPhoneCode());
            int countZero = 10-phoneNumber.length();
            String zeros = "0000000000";
            zeros = zeros.substring(0,countZero);
            //phoneNumber = zeros + phoneNumber;
            System.out.println(phoneNumber);
            String last2Digits = phoneNumber.substring(8, 10);
            String next2Digits = phoneNumber.substring(6, 8);
            String first3Digits = phoneNumber.substring(3, 6);
            String onlyPhone = first3Digits + "-" + next2Digits + "-" + last2Digits;
            phoneCode = phoneCode + "(" + phoneNumber.substring(0, 3) + ")";
            String number = phoneCode + onlyPhone;
            return number;

        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}