import java.util.Scanner;

/**
 * Created by DIMA, on 16.08.2018
 */
public class SmallParser1122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!(command = scanner.nextLine()).equals("End")){
            System.out.println(String.format("Processing \"%s\" command...", command));

        }
        System.out.println("Good bye!");
        scanner.close();
    }
}
