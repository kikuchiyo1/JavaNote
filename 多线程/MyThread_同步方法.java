package 多线程;

public class MyThread_同步方法 implements Runnable {
    static int n = 0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Method()) break;
        }
    }

    private synchronized boolean Method() {
        if(n < 1000){
            n++;
            System.out.println(Thread.currentThread().getName() + "：" + n);
        }
        else{
            return true;
        }
        return false;
    }
}