import java.util.*;

/**
 * Created by DIMA, on 30.10.2018
 */
public class Decompositions1145 {
    private static List<List<Integer>> prev = new ArrayList<>();
    private static List<List<Integer>> next = new ArrayList<>();

    private static void decompos(int number){
        List<Integer> one = new ArrayList<>();
        one.add(1);
        prev.add(one);
        for(int i = 2; i <= number; i++){
            List<Integer> maxCurrentNumber = new ArrayList<>();
            maxCurrentNumber.add(i);
            next.add(maxCurrentNumber);
            for(int j = 0; j < prev.size(); j++){
                List<Integer> list = new ArrayList<>();
                list.addAll(prev.get(j));
                list.add(1);
                next.add(list);
                //System.out.println(next);
            }


            for (List<Integer> list : prev){
                int lastIndex = list.size()-1;
                list.set(lastIndex, list.get(lastIndex) + 1);
                int sum = list.stream().reduce((i1, i2) -> i1 + i2).orElse(0);
                if (sum == i){
                    next.add(list);
                }
            }
            for(List<Integer> list : next){
                Collections.sort(list, Comparator.reverseOrder());
            }
            next = new ArrayList<>(new HashSet<>(next));
            prev = next;
            next = new ArrayList<>();
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        decompos(num);
        Collections.sort(prev, new Comparator<List<Integer>>() {
            @Override
            //432
            //4221
            public int compare(List<Integer> o1, List<Integer> o2) {
                int size1 = o1.size();
                int size2 = o2.size();
                int minSize = size1 > size2 ? size2 : size1;
                for(int i = 0; i < minSize; i++){
                    if(!o1.get(i).equals(o2.get(i))){
                        return Integer.compare(o1.get(i), o2.get(i));
                    }

                }
                return Integer.compare(size2, size1);
            }
        });
        for(List<Integer> list : prev){
            StringBuilder sb = new StringBuilder();
            for(int i : list){
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
