package 集合容器.实现类底层解析;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue详解 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.add(1);
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
/**
 *  BlockingQueue叫阻塞队列
 *  他有两个实现类
 *  1.ArrayBlockingQueue
 *      这个类的底层是一个固定长度的Object类型的数组
 *      使用重入锁来保证线程安全
 *          add方法 直接使用ReentrantLock lock方法加锁 为了避免死锁
 *          采用try finally 释放锁
 *          take方法 里面两行代码实现的 阻塞对列的阻塞
 *          while( count == 0)
 *              notEmpty.await()
 *          就是 队列中如果没有元素就等待 使用while进行自旋
 *
 *
 * */