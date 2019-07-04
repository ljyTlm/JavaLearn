package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 多线程_线程池 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newFixedThreadPool(5);
        e.submit(new MyThread("a"));
        e.submit(new MyThread("b"));
        //Thread.sleep(2000);
//      执行完上一次提交的任务 但是不接受新任务
        e.shutdown();

    }
}
