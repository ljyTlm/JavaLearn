package 多线程;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class 重入锁_ReentrantLock {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i ++) {
            TestThread testThread = new TestThread();
            testThread.start();
        }

    }
}
class TestThread extends Thread {
    @Override
    public void run() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        for (int i = 0; i < 5; i ++) {
            System.out.println(getName());
        }
        reentrantLock.unlock();
    }
}
/**
 *      重入锁的底层是 sync这个内部类 也就是AQS
 *      AQS里面维护了一个volatile修饰的状态值
 *      还有一个静态的偏移量的值 也就是每个线程在抢夺锁的时候
 *      进行cas操作都是在同一个地方尝试更新
 *
 *
 *
 * */
