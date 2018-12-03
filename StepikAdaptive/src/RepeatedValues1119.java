import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 18.07.2018.
 */
public class RepeatedValues1119 {

    private List<Integer> getList(){
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        for(String s : nums){
            list.add(Integer.parseInt(s));
        }
        //System.out.println(list);
        scanner.close();
        return list;
    }

    public static void main(String[] args) {
        RepeatedValues1119 r = new RepeatedValues1119();
        List<Integer> list = r.getList();
        Set<Integer> noDuplicates = new TreeSet<>();
        Set<Integer> l = list.stream()
                .filter(i -> !noDuplicates.add(i))
                .collect(Collectors.toSet());
        r.printSet(l);
    }

    private void printSet(Set<Integer> list){
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
