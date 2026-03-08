package 多线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class 创建线程的方式 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread t = new Thread(ft, "线程1");
        t.start();
        int result = ft.get();
        System.out.println(result+" " + t.getName());

    }
}

/*
1. 继承Thread类
① 自定义一个类继承Thread类
② 重写Thread类的run()方法
③ 创建Thread类的子类对象并且启动线程
eg:
    public class MyThread extends Thread {
        @Override
        public void run() {
        // 线程要执行的代码
        }
    }
    MyThread t = new MyThread();
    t.start();

2. 实现Runnable接口 (常用)
① 自定义一个类实现Runnable接口
② 重写run()方法
③ 创建这个自定义类的对象
④ 创建Thread类对象，并且在创建时把自定义类的对象作为参数传入，再启动线程
eg:
    public class MyThread implements Runnable {
        @Override
        public void run() {
        // 线程要执行的代码
        }
    }
    MyThread t = new MyThread();
    Thread thread = new Thread(t);
    thread.start();

3. 利用Callable接口和Future接口实现
① 自定义一个类实现Callable接口，Callable是泛型接口，代表多线程的返回值是泛型T
② 重写Callable接口中的call()方法，注意此方法有返回值，表示多线程运行的结果
③ 创建此自定义类的对象
④ 创建FutureTask类对象，并在构造方法中传入自定义类的对象，FutureTask类对象的作用是管理多线程的运行结果，可用get方法获取多线程运行结果
⑤ 创建Thread类对象，并在构造方法中传入FutureTask类对象，再启动线程
eg:
    public class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 线程要执行的代码 返回一个Integer类型的结果
        }
    }

    MyCallable mc = new MyCallable();
    FutureTask<Integer> ft = new FutureTask<>(mc);
    Thread t = new Thread(ft);
    t.start();
    int result = ft.get();

4. 不让自定义类继承任何类或者实现任何接口，直接在main里面通过匿名内部类或者Lambda表达式创建线程
    eg:(在main里)
        Student s = new Student("Bob", 80);
        Thread t = new Thread(() -> {s.setScore(100);});
        t.start();

总结：
    前两种方法不可以获取多线程的运行结果，只有第三种可以
    Thread类创建多线程的方式可拓展性较差，不能继承其他类，而后两种方法可以在实现接口的同时继承其他类
    第一种比较简便，可以直接使用Thread类的方法，后两种需要借助Thread类来使用方法
    第四种方法最简单便利，但是不适合逻辑复杂或者需要传参数的任务
    实际开发中很少用继承Thread类的方式创建线程，更多的是用实现Runnable接口或者Callable接口的方式创建线程，这符合Java并发的任务和线程分离的设计原则
*/

