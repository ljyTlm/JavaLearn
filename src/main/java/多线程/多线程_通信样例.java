package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 多线程_通信样例 {
    public static void main(String[] args) {
//        final Prin prin = new Prin();
//        new Thread(){
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        prin.printL();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println("beng!!");
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        prin.printT();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        prin.printK();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//      通过样例可以看到线程之间交替运行
//      注意：
//          （1）wait、notify方法存在Object类中 且不可重写
//          （2）wait和sleep方法的区别在于 sleep不释放锁 wait释放锁
//          （3）sleep必须传入参数 wait可以传参 可以不传 直接等待 传参的话 是多少秒之后进入等待状态
//      当多个线程时 我们可以循环的叫醒所有线程 然后 看轮到谁了 再执行谁
//      当等待的线程很多的时候 这么干的话就太愚蠢了
//      所以jdk1.5版本后引入了新特性《互斥锁》
        final MutexTest test = new MutexTest();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        test.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        test.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        test.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
//      引入了新的两个类 分别为 ReentrantLock Condition
//      ReentrantLock主要是对锁进行操作
//      Condition主要是 唤醒和等待指定线程
    }
}
class MutexTest{
    private ReentrantLock r = new ReentrantLock();
    private Condition c1 = r.newCondition();
    private Condition c2 = r.newCondition();
    private Condition c3 = r.newCondition();

    public static int val = 0;

    public void print1() throws InterruptedException {
        r.lock();
        if (val != 0){
            c1.await();
        }
        System.out.print("我");
        System.out.print("叫");
        System.out.print("李");
        System.out.print("金");
        System.out.print("玉");
        System.out.println();
        val = 1;
        c2.signal();
        r.unlock();
    }
    public void print2() throws InterruptedException {
        r.lock();
        if (val != 1){
            c2.await();
        }
        System.out.print("你");
        System.out.print("是");
        System.out.print("唐");
        System.out.print("珑");
        System.out.print("铭");
        System.out.println();
        val = 2;
        c3.signal();
        r.unlock();
    }
    public void print3() throws InterruptedException {
        r.lock();
        if (val != 2){
            c3.await();
        }
        System.out.print("他");
        System.out.print("是");
        System.out.print("庞");
        System.out.print("太");
        System.out.print("郎");
        System.out.println();
        val = 0;
        c1.signal();
        r.unlock();
    }
}
//class Prin {
//    public static int val = 0;
//    public void printL() throws InterruptedException {
//        synchronized (this){
//            while (val != 0){
//                this.wait();
//            }
//            System.out.print("我");
//            System.out.print("叫");
//            System.out.print("李");
//            System.out.print("金");
//            System.out.print("玉");
//            System.out.println();
//            val = 1;
//            this.notifyAll();
//        }
//
//    }
//    public void printT() throws InterruptedException {
//        synchronized (this){
//            while (val != 1){
//                this.wait();
//            }
//            System.out.print("你");
//            System.out.print("是");
//            System.out.print("唐");
//            System.out.print("珑");
//            System.out.print("铭");
//            System.out.println();
//            val = 2;
//            this.notifyAll();
//        }
//
//    }
//
//    public void printK() throws InterruptedException {
//        synchronized (this){
//            while (val != 2){
//                this.wait();
//            }
//            System.out.print("他");
//            System.out.print("是");
//            System.out.print("庞");
//            System.out.print("太");
//            System.out.print("郎");
//            System.out.println();
//            val = 0;
//            this.notifyAll();
//        }
//    }
//}
