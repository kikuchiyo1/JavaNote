package 多线程;

public class 线程同步 {
    public static void main(String[] args) throws InterruptedException {
        long time1 = System.currentTimeMillis();

        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "线程1");
        Thread t2 = new Thread(mt, "线程2");
        Thread t3 = new Thread(mt, "线程3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("耗时：" + (System.currentTimeMillis() - time1)+"ms");
    }
}
/*
一. 同步代码块 演示见同包内的 MyThread 类
多线程同时读写共享变量时，可能会造成逻辑错误，因此需要通过synchronized加锁来同步
1. 加锁方式:
    synchronized(obj){
        //需要同步的代码
    }
    其中obj是一个锁对象，可以是任意对象，但是一定要是唯一的(用static final修饰即可)，多个线程必须使用同一个锁对象才能实现同步

2. 加锁的原理：
    加锁后，线程会尝试获取锁对象，获取成功后才会执行同步代码，获取失败则阻塞等待，保证同一时刻只有一个线程能执行同步代码

3. 合理使用锁：
    ① 只对会改变同一个共享变量的代码加锁，因为加锁会导致无法并发访问，降低效率
    ② 读写不可变对象时不需要同步代码
    ③ 尽量避免锁的嵌套
    ④ 锁里面不应该包含耗时操作，如sleep、IO、计算 后果自负

二. 同步方法 演示见同包内的 MyThread_同步方法 类
就是把synchronized关键字加在方法上
1. 特点
    ① 同步方法会锁住方法里的所有代码
    ② 同步方法的锁对象不可制订，非静态方法是this，静态方法是当前类的字节码文件对象(类名.class)

2. 注意点
    ① 想写同步方法，可以先写同步代码块，然后用ctrl+alt+m提取方法
    ② 用同步方法，就最好用实现Runnable接口的方式创建多线程，这样会使得同步方法的锁对象唯一，因为这个类只会创建一次实例
    ③ 同步方法不能声明为static
    ④ 同步方法不能被继承
    ⑤ 题外话：单线程的程序适合用StringBuilder，多线程适合用StringBuffer，后者虽然效率稍低，但是是线程安全的，内部方法都是同步方法

三. lock锁 演示见同包内的 MyThread_Lock锁 类
使用synchronized关键字加锁的缺点是不能自己控制锁的释放时机，Java提供了Lock接口解决这个问题

1. 创建锁对象
    Lock是接口，不能实例化，需要用它的实现类ReentrantLock来创建锁对象：
    ReentrantLock lock = new ReentrantLock();

2. 方法
    lock.lock();      // 获取锁
    lock.unlock();    // 释放锁
    lock.tryLock();   // 尝试获取锁，成功返回true，失败返回false

3. 注意点
    ① Lock需要手动释放锁，一般用try-finally语句保证锁的释放，避免死锁
    ② Lock锁在创建时要设定为static 保证锁对象唯一

四. 总结
    写多线程程序时按照以下四步：
    1. 写循环
    2. 同步代码块，也可以写完ctrl+alt+m提取成同步方法
    3. 判断共享数据是否到达末尾(到达末尾的情况)
    4. 判断共享数据是否到达末尾(没到达末尾的情况，写核心逻辑)
*/