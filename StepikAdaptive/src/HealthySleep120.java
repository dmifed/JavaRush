import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DIMA on 13.07.2018.
 */
public class HealthySleep120 {
    private int a,b,h;

    private void readHours(){
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            a = Integer.parseInt(bufferedReader.readLine());
            b = Integer.parseInt(bufferedReader.readLine());
            h = Integer.parseInt(bufferedReader.readLine());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public String howSleep(){
        readHours();
        if(h<a){            return "Deficiency";        }
        if(h>b){            return "Excess";        }
        return "Normal";
    }

    public static void main(String[] args) {
        HealthySleep120 healthySleep120 = new HealthySleep120();
        System.out.println(healthySleep120.howSleep());
    }



}
