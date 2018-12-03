package almostLikeASql359;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by DIMA on 13.07.2018.
 */
public class Main {
    public static void main(String[] args) {

        //LogEntry(Date created, String login, String url)
        LogEntry logEntry1 = new LogEntry(new Date(10000), "ures1", "yandex");
        LogEntry logEntry2 = new LogEntry(new Date(100000), "ures2", "google");
        LogEntry logEntry3 = new LogEntry(new Date(1000000), "ures3", "bing");
        LogEntry logEntry4 = new LogEntry(new Date(10000000), "ures4", "yandex");
        LogEntry logEntry5 = new LogEntry(new Date(100000000), "ures5", "yandex");
        LogEntry logEntry6 = new LogEntry(new Date(1000000000), "ures6", "google");
        LogEntry logEntry7 = new LogEntry(new Date(2000000000), "ures7", "yandex");

        List<LogEntry> logs = new ArrayList<>(Arrays.asList(logEntry1, logEntry2, logEntry3, logEntry4, logEntry5, logEntry6, logEntry7));

        Map<String, Long> clickCount =
                logs.stream()
                        .collect(Collectors.toMap(t -> t.getUrl(), a -> 1L, (a1, a2) -> (a1+1)));

        printMap(clickCount);
    }

    static void printMap(Map<String, Long> map){
        for(Map.Entry<String, Long> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
