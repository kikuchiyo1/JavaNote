package 多线程;

import java.util.concurrent.ArrayBlockingQueue;

public class CookBlockingQueue implements Runnable {

    private ArrayBlockingQueue<String> q;

    CookBlockingQueue(ArrayBlockingQueue<String> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                q.put("焖子");
                System.out.println(Thread.currentThread().getName() + " 做了一个焖子");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
