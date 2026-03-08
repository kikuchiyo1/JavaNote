package 多线程;

public class Cook implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Desk.lock.lock();
                if (Desk.count == 0) {
                    break;
                } else {
                    if(Desk.foodFlag == 1){
                        Desk.condition.await();
                    } else {
                        Desk.foodFlag = 1;
                        System.out.println(Thread.currentThread().getName()+" 做了一个焖子");
                        Desk.condition.signalAll();
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
