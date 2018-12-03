import java.util.*;

/**
 * Created by DIMA, on 28.08.2018
 */
public class MilitaryUnit1107 {
    private static class Soldier implements Comparable{
        int height;
        public Soldier(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            Soldier soldier = (Soldier) o;
            return Integer.compare(this.height, soldier.height);
        }

        @Override
        public String toString() {
            return "Soldier " + height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder outPlaces = new StringBuilder();
        int commands = scanner.nextInt();
        List<Soldier> list = new ArrayList<>();
        for(int i = 0; i < commands; i++){
            int command = scanner.nextInt();
            if(command == 1){
                int height = scanner.nextInt();
                Soldier s = new Soldier(height);
                list.add(s);
                Collections.sort(list, new Comparator<Soldier>() {
                    @Override
                    public int compare(Soldier o2, Soldier o1) {
                        return o1.compareTo(o2);
                    }
                });
                int place = list.indexOf(s);
                //System.out.println("test : " + s);
                outPlaces.append(place).append(" ");
            }
            if(command == 2){
                int indexToRemove = scanner.nextInt();
                //System.out.println("removing " + list.get(indexToRemove));
                list.remove(indexToRemove);
            }
        }
        System.out.println(outPlaces.toString().trim());
    }
}
