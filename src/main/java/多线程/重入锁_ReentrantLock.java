package 多线程;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 重入锁_ReentrantLock {
    public static void main(String[] args) {

        final Util util = new Util();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    util.printA();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    util.printB();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    util.printC();
                }
            }
        }.start();
    }
    static class Util {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();

        public void printA() {
            reentrantLock.lock();
            System.out.println("A");
            conditionB.signal();
            try {
                conditionA.await();
            }catch (Exception e) {}

            reentrantLock.unlock();
        }

        public void printB() {
            reentrantLock.lock();
            System.out.println("B");
            conditionC.signal();
            try {
                conditionB.await();
            }catch (Exception e) {}

            reentrantLock.unlock();
        }

        public void printC() {
            reentrantLock.lock();
            System.out.println("C");
            conditionA.signal();
            try {
                conditionC.await();
            }catch (Exception e) {}

            reentrantLock.unlock();
        }
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
