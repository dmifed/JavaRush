package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        //{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
        //"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
        System.out.println(getQuery(params));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(value != null){
                sb.append(key);
                sb.append(" = '");
                sb.append(value);
                sb.append("' and ");
            }
        }
        int lastAnd = sb.lastIndexOf("and")-1;
        int len = sb.toString().length();
        if (len-lastAnd == 5){
            return sb.substring(0, lastAnd);
        }


        return sb.toString();
    }
}
