package 多线程;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int n = 0;
        for(int i=1; i <= 100; i++){
            n += i;
        }
        return n;
    }
}
