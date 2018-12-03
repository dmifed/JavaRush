import java.util.Scanner;

/**
 * Created by DIMA, on 24.07.2018
 */
public class MKAD14 {
    public static final int MKAD_LENGHT = 109;
    private int speed, hours;
    private int lenght;
    private int mark;

    public MKAD14(int speed, int hours) {
        this.speed = speed;
        this.hours = hours;
        this.lenght = speed*hours;
        this.mark = lenght%MKAD_LENGHT;
        if (mark<0){
            mark = MKAD_LENGHT + mark;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MKAD14 mkad14 = new MKAD14(scanner.nextInt(), scanner.nextInt());
        scanner.close();
        System.out.println(mkad14.mark);

    }
}
