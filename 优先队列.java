import java.util.*;

public class 优先队列 {
    public static void main(String[] args) {
        Queue <Integer> queue = new java.util.PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // Max-heap: larger numbers have higher priority
            }
        });
        queue.add(1);
        queue.add(3);
        queue.add(2);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}