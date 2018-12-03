import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 23.08.2018
 */
public class SortTimeMoments1106 {
    private static class TimeMoment{
        private int hours;
        private int minutes;
        private int seconds;
        private int allSeconds;
        public TimeMoment(int hours, int minutes, int seconds){
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.allSeconds = hours * 60 * 60 + minutes * 60 + seconds;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof TimeMoment)) return false;
            TimeMoment test = (TimeMoment) obj;
            if(test.hashCode() != this.hashCode()) return false;
            return test.hours == hours && test.minutes == minutes && test.seconds == seconds;
        }

        @Override
        public String toString() {
            return hours + " " + minutes + " " + seconds;
        }

        @Override
        public int hashCode() {
            return 31*hours + 31*minutes + 31*seconds;
        }
    }

    private static List<TimeMoment> getMoments(){
        Scanner scanner = new Scanner(System.in);
        List<TimeMoment> list = new ArrayList<>();
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++){
            list.add(new TimeMoment(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        return list;
    }

    public static void main(String[] args) {
        List<TimeMoment> list = getMoments();
        list.sort(new Comparator<TimeMoment>() {
            @Override
            public int compare(TimeMoment o1, TimeMoment o2) {
                if(o1.allSeconds > o2.allSeconds) return 1;
                if(o1.allSeconds < o2.allSeconds) return -1;
                return 0;
            }
        });

        for (TimeMoment t : list){
            System.out.println(t);
        }
    }
}
