package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foodie implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Desk.lock.lock();
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.foodFlag == 1) {
                        Desk.count--;
                        System.out.println(Thread.currentThread().getName()+" 吃了一个焖子,还能吃 " + Desk.count + " 个焖子");
                        Desk.condition.signalAll();
                        Desk.foodFlag = 0;
                    } else {
                        Desk.condition.await();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                Desk.lock.unlock();
            }
        }
    }
}
