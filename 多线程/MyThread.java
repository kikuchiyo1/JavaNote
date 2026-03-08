package 多线程;


public class MyThread implements Runnable {
    static int n = 0;
    static final Object lock = new Object();
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock){
                if(n < 1000){
                    n++;
                    System.out.println(Thread.currentThread().getName() + "：" +n);
                }
                else{
                    break;
                }
            }
        }
    }
}