package 多线程;

import java.util.concurrent.Semaphore;

public class 信号量_Semaphore {
    public static void main(String[] args) {
        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C = new Semaphore(0);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        A.acquire();
                        System.out.println("A");
                        B.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        B.acquire();
                        System.out.println("B");
                        C.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        C.acquire();
                        System.out.println("C");
                        A.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
/**
 *      信号量保证了 一个信号量下线程运行的个数 acquire减一 release加一
 * */