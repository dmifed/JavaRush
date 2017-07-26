package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;

        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }


    }
    public int hashCode(){
        return 31*users.hashCode();

    }
    public Solution clone() throws CloneNotSupportedException{
        super.clone();
        Solution solClone = new Solution();
        for(Map.Entry<String, User> entry : this.users.entrySet()){
            solClone.users.put(entry.getKey(), entry.getValue());
        }
        return solClone;
    }


    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public User clone()throws CloneNotSupportedException{
            return new User(age, name);
        }

        @Override
        public int hashCode() {
            int resStr = name != null ? name.hashCode() : 0;
            return 31*age + resStr;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(!(obj instanceof User)) return false;
            if(obj == this) return true;
            User objUser = (User) obj;
            if(objUser.hashCode() == this.hashCode()){
                if(objUser.age == this.age && objUser.name == this.name) return true;
            }
            return false;
        }
    }
}
