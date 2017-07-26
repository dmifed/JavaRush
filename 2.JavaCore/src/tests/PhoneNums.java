package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dima on 20.02.2017.
 */
public class PhoneNums {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int phoneCodeInt = Integer.parseInt(reader.readLine());
        int phoneNumberInt = Integer.parseInt(reader.readLine());

        String phoneNumber = String.valueOf(phoneNumberInt);
        String phoneCode = "+" + String.valueOf(phoneCodeInt);
        int countZero = 10-phoneNumber.length();
        String zeros = "0000000000";
        zeros = zeros.substring(0,countZero);
        phoneNumber = zeros + phoneNumber;
        System.out.println(phoneNumber);
        String last2Digits = phoneNumber.substring(8, 10);
        String next2Digits = phoneNumber.substring(6, 8);
        String first3Digits = phoneNumber.substring(3, 6);
        String onlyPhone = first3Digits + "-" + next2Digits + "-" + last2Digits;
        phoneCode = phoneCode + "(" + phoneNumber.substring(0, 3) + ")";
        String number = phoneCode + onlyPhone;
        System.out.println(number);
    }
}
