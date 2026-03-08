package 多线程;

public class 等待唤醒机制_一般实现 {
    public static void main(String[] args) {
        Cook c = new Cook();
        Foodie f = new Foodie();
        Thread t1 = new Thread(c, "厨师 1");
        Thread t2 = new Thread(f, "大卫戴 1");
        Thread t3 = new Thread(f, "大卫戴 2");
        Thread t4 = new Thread(c, "厨师 2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/*
等待唤醒机制是多线程中常用的一种线程间通信方式，主要用于解决线程之间的协作问题，如生产者消费者问题等。
具体见我写的三个类：Desk、Cook和Foodie，分别代表桌子、厨师和大卫戴
思路一览：
1. 消费者的代码逻辑
  ① 判断桌子上是否有食物
  ② 如果没有，则等待
  ③ 如果有，则吃掉
  ④ 吃完以后，唤醒生产者生产食物

2. 生产者的代码逻辑
  ① 判断桌子上是否有食物
  ② 如果有，则等待
  ③ 如果没有，则生产食物
  ④ 将食物放在桌子上
  ⑤ 唤醒消费者吃食物

3. 用到的方法
  ① void wait()：让当前线程进入等待状态，直到被其他线程唤醒
  ② void notify()：随机唤醒一个正在等待的线程
  ③ void notifyAll()：唤醒所有正在等待的线程
    以上方法都是Object类的方法，适用于使用synchronized锁住的同步代码块或同步方法中
    如果要使用Lock锁进行线程同步，则需要用到Condition接口中的await()、signal()和signalAll()方法来实现等待唤醒机制
    具体见同包中的Desk类、Cook类和Foodie类的实现

4. 阻塞队列实现 代码见同包(因为打印语句写在了锁的外面，所以输出会重复，但是实际上数据是严格遵守生产者消费者的逻辑的)
    阻塞队列有两种类型：ArrayBlockingQueue和LinkedBlockingQueue
  ① ArrayBlockingQueue：基于数组实现的有界阻塞队列，
  ② LinkedBlockingQueue：基于链表实现的无界阻塞队列（默认容量为Integer.MAX_VALUE），也可以指定容量
*/
