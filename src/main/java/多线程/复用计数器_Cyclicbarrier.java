package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class 复用计数器_Cyclicbarrier {
    public static void main(String[] args) throws Exception{
        int size = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);
        for (int i = 0; i < size; i ++) {
            new MyThread(cyclicBarrier).start();
        }
        Thread.sleep(2000);
        for (int i = 0; i < 2; i ++) {
            new MyThread(cyclicBarrier).start();
        }

    }
    static class MyThread extends Thread {

        CyclicBarrier c;

        MyThread(CyclicBarrier c) {
            this.c = c;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName()+"我准备就绪了");
                c.await();
                System.out.println(getName()+"我正在运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
