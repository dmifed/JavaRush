import java.util.Scanner;

/**
 * Created by DIMA, on 26.07.2018
 */
public class SymmetricalNumber124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.next().split("");
        if(strings.length > 5){
            System.out.println("Wrong number!");
        }
        switch (strings.length){
            case 4 : decisionSymmetrical(strings); break;
            case 3 :{
                String[] newStrings =  {"0", strings[0], strings[1], strings[2]};
                decisionSymmetrical(newStrings);
                break;
            }
            case 2 :{
                String[] newStrings =  {"0", "0", strings[0], strings[1]};
                decisionSymmetrical(newStrings);
                break;
            }
            case 1 :{
                String[] newStrings =  {"0", "0", "0", strings[0]};
                decisionSymmetrical(newStrings);
                break;
            }
        }
    }
    private static void decisionSymmetrical (String[] strings){
        if (strings[0].equals(strings[3]) && strings[1].equals(strings[2])){
            System.out.println(1);
        }else {
            System.out.println(37);
        }
    }
}
