package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 99999999;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }


    /*
    Используй только операции:
    1) =
    2) | ---- OR
    3) & ---- AND
    4) >> ---- move right
    5) << ---- move left
    6) ~ ---- NOT
    7) цифры от 0 до 9 включительно
    8) круглые скобки
    9) оператор "return" для возврата результата метода.
    ЗАПРЕЩЕНО создавать переменные, использовать циклы, условные операторы и прочее.
     */

    public int resetLowerBits(int number) {
        number |= number>>1;
        number |= number>>2;
        number |= number>>4;
        number |= number>>8;
        number |= number>>8;
        number |= number>>8;
        number &= ~(number>>1);
        return number;
        //напишите тут ваш код
    }
}