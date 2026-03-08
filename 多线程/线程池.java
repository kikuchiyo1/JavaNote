package 多线程;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池 {
    public static void main(String[] args) {
        ExecutorService poor = Executors.newFixedThreadPool(5);
        Cook c = new Cook();
        Foodie f = new Foodie();
        poor.submit(c);
        poor.submit(c);
        poor.submit(f);
        poor.submit(f);
        poor.close();
    }
}

/*
Java的线程池可以实现线程复用，减少系统开销
Java提供了ExecutorService接口和Executors工具类来创建线程池，常用的线程池有：
1. newFixedThreadPool(int nThreads)：创建一个固定大小的线程池
2. newCachedThreadPool()：创建一个没有上限的线程池，线程数量根据需要自动增加

自定义线程池：
ThreadPoolExecutor poor = new ThreadPoolExecutor(...);

线程池的运行逻辑是这样的：
1. 当有任务提交时，如果任务数小于核心线程数，则创建对应的线程执行任务
2. 当任务数大于核心线程数时，将任务放入任务队列中，等待空闲的线程执行
3. 当任务数大于核心线程数+队列容量时，创建临时线程执行任务
4. 若任务数大于最大线程数+队列容量，将多的任务用拒绝策略处理

创建自定义线程池需要指定七个参数：
1. 核心线程数 即使空闲时核心线程也不会被回收
2. 最大线程数 核心线程数+临时线程数，临时线程数会在空闲时被回收
3. 线程空闲时间 临时线程空闲时被回收的时间
4. 时间单位 线程空闲时间的单位 一般用TimeUnit这个工具类来指定
5. 任务队列 用来存放等待执行的任务的队列，用阻塞队列来实现 就是ArrayBlockingQueue和LinkedBlockingQueue
6. 线程工厂 用来创建线程的工厂
7. 拒绝策略 任务的拒绝策略 有四种：
    ① AbortPolicy：默认的拒绝策略，丢弃任务并抛出RejectedExecutionException异常
    ② CallerRunsPolicy：调用任务的run()方法绕过线程池直接执行
    ③ DiscardPolicy：丢弃任务，不抛出异常 不推荐
    ④ DiscardOldestPolicy：丢弃队列中等待最久的任务，然后执行当前任务
eg：
ThreadPoolExecutor poor = new ThreadPoolExecutor(
    3,
    6,
    1,
    TimeUnit.MINUTES,
    new ArrayBlockingQueue<>(10),
    Executors.defaultThreadFactory(),
    new ThreadPoolExecutor.DiscardOldestPolicy()
);
*/
