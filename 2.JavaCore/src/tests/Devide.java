package tests;

/**
 * Created by dima on 06.04.2017.
 */
public class Devide {
    public static void main(String[] args) {
        System.out.println(Devide.chicking(121));

    }

    public static boolean chicking(long num){
        boolean isGood = true;
        long ostatokCurrent = 0;
        long ostatokOld = 0;
        long result = num;

        while(result != 0){
            ostatokOld = result%10;
            result = result/10;
            ostatokCurrent = result%10;
            if (ostatokCurrent>ostatokOld){
                isGood = false;
                return isGood;
            }
        }
        return isGood;
    }

}
