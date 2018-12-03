import java.util.Scanner;

/**
 * Created by DIMA on 19.07.2018.
 */
public class SmallestInteger1159 {
    public static void main(String[] args) {
        SmallestInteger1159 s = new SmallestInteger1159();
        int[] aTest = s.getNumbers();
        //System.out.println(s.findNOD(aTest));
        System.out.println(s.findNOK(aTest));

    }
    private int[] getNumbers(){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[2];
        numbers[0] = scanner.nextInt();
        numbers[1] = scanner.nextInt();
        return numbers;
    }

    private int findNOD(int [] ints){
        int a = ints[0];
        int b = ints[1];
        if (a==b) return a;
        int nod = 0;
        int r = 1;

        while (true){
            r = b%a;
            if(r != 0){
                b = a;
                a = r;
            }else {
                return a;
            }

        }
    }

    private int findNOK(int[] ints){
        int nod = findNOD(ints);
        return ints[0]*ints[1]/nod;
    }


}
