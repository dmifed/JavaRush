import java.util.Scanner;

/**
 * Created by DIMA, on 24.07.2018
 */
public class SizeOfParts13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int larger = 0, smaller = 0, perfect = 0;
        for (int i = 0; i<count; i++){
            int state = 0;
            if(scanner.hasNext()){
                state = scanner.nextInt();
            }else {break;}

            switch (state){
                case 0 : perfect++;
                    break;
                case 1 : larger++;
                    break;
                case -1 : smaller++;
                    break;
            }
        }
        scanner.close();
        System.out.printf("%d %d %d", perfect, larger, smaller);
    }
}
