package 多线程;

import java.util.concurrent.ArrayBlockingQueue;

public class FoodieBlockingQueue implements Runnable {

    private ArrayBlockingQueue<String> q;

    FoodieBlockingQueue(ArrayBlockingQueue<String> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String s = q.take();
                System.out.println(Thread.currentThread().getName() + " 吃了一个" + s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
