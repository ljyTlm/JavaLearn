package 多线程;

import java.util.concurrent.CountDownLatch;

public class 计数器_CountDownLatch {
    public static void main(String[] args) {
        int size = 100;
        CountDownLatch count = new CountDownLatch(size);
        for(int i = 0; i < size; i ++) {
            new Thread(new MyRunnable_1(count)).start();
        }
    }
}
class MyRunnable_1 implements Runnable {

    public final CountDownLatch count;

    MyRunnable_1(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在准备");
        count.countDown();
        try {
            count.await();
        } catch (InterruptedException e) {

        }
        System.out.println(Thread.currentThread().getName()+"我正在运行");

    }
}

/**
 *      还是利用sync AQS 只不过 原先对state的值是一个线程操作 为0释放锁 现在是多个线程
 *      操作为0释放锁，然后就可以实现倒计时的功能
 * */