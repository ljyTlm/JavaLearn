package 多线程;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 读写锁_ReentrantReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        BlockingQueue blockingQueue = new ArrayBlockingQueue(100);
        /**
         *      读写锁内部自己封装了两个内部类 一个ReadLock 和 一个WriteLock
         *      这两个类都实现了Lock类实现加锁解锁，重要的是这两个类在实际应用中
         *      共用一个同步器，也就是AQS 按照我的理解一定是共用一个
         *
         * */

    }
}
