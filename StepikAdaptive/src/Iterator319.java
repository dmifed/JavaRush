import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 20.07.2018.
 */
public class Iterator319 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ints = Arrays.stream(reader.readLine().split(" "))
                .map(t -> Integer.parseInt(t)).sorted()
                .collect(Collectors.toList());
        reader.close();
        Iterator<Integer> integerIterator = ints.iterator();
        while (integerIterator.hasNext()){
            int num = integerIterator.next();
            if(num%2 != 0){
                System.out.println(num);
            }
        }


        //lets go


    }
}
