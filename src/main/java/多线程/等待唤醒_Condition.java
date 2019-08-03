package 多线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 等待唤醒_Condition {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();
        final Condition condition3 = lock.newCondition();
        final AtomicInteger a = new AtomicInteger(0);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (a.get()%3 != 0) {
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    a.addAndGet(1);
                    condition2.signal();
                    lock.unlock();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (a.get()%3 != 1) {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    a.addAndGet(1);
                    condition3.signal();
                    lock.unlock();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (a.get()%3 != 2) {
                        try {
                            condition3.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    a.addAndGet(1);
                    condition1.signal();
                    lock.unlock();
                }
            }
        }.start();
    }
}
/**
 *      Condition 与 Lock 配合使用 取代 Object的wait notify 和 synchronized
 *      Condition 最大的特点就是指定唤醒！！！
 * */