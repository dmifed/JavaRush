package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    Object o = new Object();

    @Override
    public boolean equals(Object n) {
        if(n == this){
            return true;
        }
        if(!(n instanceof Solution)){
            return false;
        }
        if(n == null){
            return false;
        }
        if(n.getClass() != this.getClass()){
            return false;
        }
        Solution n1 = (Solution) n;
        if(n.hashCode() == this.hashCode()){
            return n1.first == first && n1.last == last;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int firstRes = first != null ? first.hashCode() : 0;
        int lastRes = last != null ? last.hashCode() : 0;
        return 31 * firstRes + lastRes;
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        //System.out.println(new Solution("Duck", "Donald").hashCode());
        //System.out.println(new Solution("Donald", "Duck").hashCode());
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution("Duck", "Donald")));
        s.add(new Solution(null, "A"));
        System.out.println(s.contains(new Solution(null, "A")));
    }
}
