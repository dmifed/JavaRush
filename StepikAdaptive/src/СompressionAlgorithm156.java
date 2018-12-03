import java.util.Scanner;

/**
 * Created by DIMA, on 22.08.2018
 */
public class СompressionAlgorithm156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] letters = scanner.nextLine().split("");
        scanner.close();
        StringBuilder sb = new StringBuilder();
        int countLetter = 1;
        for(int i = 1; i<letters.length; i++){
            if(letters[i-1].equals(letters[i])){
                countLetter++;
            }else {
                sb.append(letters[i-1]).append(countLetter);
                countLetter = 1;
            }
        }
        sb.append(letters[letters.length-1]).append(countLetter);
        System.out.println(sb.toString());
    }
}
