package tests;

/**
 * Created by dima on 13.04.2017.
 */
public class CompareStringAndChar {
    public static void main(String[] args) {
        int a = 'b';
        String aStr = "b";
        char aChar = aStr.toCharArray()[0];
        System.out.println(a == aChar);
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        boolean[][] isCheked = new boolean[crossword.length][crossword[0].length];
        for(boolean[] b : isCheked){
            for(boolean bb : b){
                System.out.print(bb + " ");
            }
            System.out.println();
        }




    }


}
