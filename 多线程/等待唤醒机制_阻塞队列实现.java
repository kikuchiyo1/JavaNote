package 多线程;

import java.util.concurrent.ArrayBlockingQueue;

public class 等待唤醒机制_阻塞队列实现 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(10);
        CookBlockingQueue c = new CookBlockingQueue(q);
        FoodieBlockingQueue f = new FoodieBlockingQueue(q);
        Thread t1 = new Thread(c, "厨师 1");
        Thread t2 = new Thread(f, "大卫戴 1");
        Thread t3 = new Thread(f, "大卫戴 2");
        Thread t4 = new Thread(c, "厨师 2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
