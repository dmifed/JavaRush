import java.util.Scanner;

/**
 * Created by DIMA, on 26.07.2018
 */
public class Turtle1135 {
    private static int getFactor(String direction){
        if(direction.equals("South") || direction.equals("West")) {
            return -1;
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCoord = scanner.nextInt();
        int finishVert = 0;
        int finishGor = 0;
        for (int i = 0; i< countCoord; i++){
            String direction = scanner.next();
            int c = scanner.nextInt();
            if(direction.equals("South") || direction.equals("North")){
                finishVert += c * getFactor(direction);
            }else {
                finishGor += c * getFactor(direction);
            }
        }
        System.out.println(finishGor + " " + finishVert);
    }

}
