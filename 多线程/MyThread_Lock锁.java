package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread_Lock锁 implements Runnable {
    static int n = 0;
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(10);
                lock.lock();
                if(n < 1000){
                    n++;
                    System.out.println(Thread.currentThread().getName() + "：" + n);
                }
                else{
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                lock.unlock();
            }
        }
    }
}
