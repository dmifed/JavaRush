import java.util.Scanner;

/**
 * Created by DIMA, on 02.08.2018
 */
public class Desck17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students1 = scanner.nextInt();
        int students2 = scanner.nextInt();
        int students3 = scanner.nextInt();

        System.out.println(students1/2 + students1%2 + students2/2 + students2%2 + students3/2 + students3%2);

    }
}
