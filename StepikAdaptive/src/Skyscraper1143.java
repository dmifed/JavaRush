/**
 * Created by DIMA, on 27.08.2018
 */
public class Skyscraper1143 {
    public static void main(String[] args) {
        int maxFloorToTest = new java.util.Scanner(System.in).nextInt();

        for(int i = 0; i < maxFloorToTest; i++){
            if(i*(i+1)/2 >= maxFloorToTest-1){
                System.out.println(i);
                break;
            }
        }
    }
}
