import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by DIMA on 13.07.2018.
 */
public class Queue3112 {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));
        queue.add(5);
        queue.poll();
        queue.poll();
        System.out.println(queue);
    }
}
