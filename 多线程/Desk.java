package 多线程;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Desk {
    //作用：控制生产者和消费者的交替执行
    public static int foodFlag = 0; //0表示没有食物，1表示有食物

    public static int count = 50; //生产者和消费者的执行次数,可以理解为消费者能吃多少碗面

    public static final Object lock1 = new Object(); //锁对象，保证线程安全

    public static final Lock lock = new ReentrantLock();

    public static final Condition condition = lock.newCondition();
}
