package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dima on 20.02.2017.
 */
public class RegexpDigit {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phone = reader.readLine();
        phone = "+" + phone.replaceAll("\\D", "");
        System.out.println(phone);
    }
}
