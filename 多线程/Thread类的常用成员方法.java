package 多线程;

public class Thread类的常用成员方法 {
    public static void main(String[] args) {

    }
}
/*
1. String getName()：获取线程的名字
    ① 如果线程的名字没有设置，则默认为Thread-0,1,2...
    ② 给线程设置名字，可以使用setName方法，也可以在类中继承Thread类的构造方法，这样就能在创建线程对象时设置名字

2. void setName(String name)：设置线程的名字

3. static void sleep(long time)：让当前正在执行的线程睡眠指定的时间，单位是毫秒

4. static void currentThread()：获取当前线程的对象
    哪条线程调用此方法，此时获取的就是哪条线程的对象

5. setPriority(int priority)：设置线程的优先级
    线程的优先级：1-10，默认5，Java的多线程运行模式是抢占式运行，优先级越高的线程抢占到cpu的概率越高

6. final getPriority()：获取线程的优先级

7. setDaemon(boolean daemon)：设置线程为守护线程
    守护线程是为其他线程服务的线程，在JVM中，当所有非守护线程结束后，不管守护线程是否结束，JVM都会退出
    注意守护线程不能持有任何需要关闭的资源，例如打开文件等，否则JVM退出时，守护线程没有机会关闭文件，会导致数据丢失

8. static void yield()：出让线程/礼让线程
    让当前正在执行的线程暂停一下，让其他线程有机会执行，礼让线程只是让出当前线程占用的cpu时间片，礼让线程只是一个建议，JVM不一定会采纳

9. static void join()：插入线程，让当前线程等待，直到调用join的线程结束
    如果线程A调用了线程B的join方法，那么线程A就会进入等待状态，直到线程B执行完毕，线程A才会继续执行

*/
