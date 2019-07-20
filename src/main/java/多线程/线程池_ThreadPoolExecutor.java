package 多线程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class 线程池_ThreadPoolExecutor {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = MyThreadPool.getPoolAndSetSize(3);
        for(int i = 0; i < 5; i ++) {
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("有一个代码块被执行了");
                }
            });
        }
        myThreadPool.shutdown();

    }
}
class MyThreadPool {

    private int POOL_SIZE;

    private BlockingQueue<Runnable> queue;

    private List<Thread> list;

    private volatile boolean stop = true;

    MyThreadPool(int size) {
        POOL_SIZE = size;
        queue = new LinkedBlockingDeque<>();
        list = Collections.synchronizedList(new ArrayList<Thread>());
        for(int i = 0; i < POOL_SIZE; i ++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (stop || queue.size() > 0) {
                        try {
                            queue.take().run();
                            System.out.println(getName());
                        }catch (Exception e) {}
                    }
                }
            };
            thread.start();
            list.add(thread);
        }
    }

    public static MyThreadPool getPoolAndSetSize(int size) {
        return new MyThreadPool(size);
    }


    public void submit(Runnable runnable) {
        queue.offer(runnable);
    }

    public void shutdown() {
        stop = false;
    }

}
