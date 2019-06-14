package 多线程;

import java.sql.Struct;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class 多线程样例 {
    public static void main(String[] args) throws InterruptedException {
//        并行：多个cpu同时执行多个任务
//        并发：一个cpu轮流执行多个任务
//      创建线程的方法1： 继承Thread类
            MyThread one = new MyThread("线程1");
            MyThread two = new MyThread("线程2");
            one.start();
            two.start();
//      线程创建后 重写run方法 真正的启动 要执行start方法
//      创建线程的方法2：实现Runnable接口
            MyRunnable runnable_1 = new MyRunnable("线程3");
            new Thread(runnable_1).start();
//      两种方法的对比：
//          方法2是对方法1的一种补充 因为方法1有个弊端
//          java是单继承设计 所以当存在父类的时不能继承Thread
//      拓展：创建线程的方法3： 匿名内部类
            new Thread(){
                @Override
                public void run() {
                    while (true) System.out.println("我是线程4");
                }
            }.start();
            new Thread(new Runnable() {
                public void run() {
                    while (true) System.out.println("我是线程5");
                }
            }).start();
//      1.获取当前线程对象
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
//      2.使当前线程休眠
            Thread.sleep(1000);
//      3.设置守护线程
//        守护线程：当非守护线程结束时、不管守护线程执没执完 都会挂掉
            one.setDaemon(true);
//      4.当前线程加入线程
        final Thread a = new Thread() {
            @Override
            public void run() {
                while (true) System.out.println("我是线程1");
            }
        };
        final Thread b = new Thread(){
            @Override
            public void run() {
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) System.out.println("我是线程1");
            }
        };
//      5.礼让线程
        Thread c = new Thread() {
            @Override
            public void run() {
                Thread.yield(); //效果不好
                while (true) System.out.println("我是线程1");
            }
        };
//      6.设置线程的优先级
        c.setPriority(Thread.MAX_PRIORITY); //设置最大的线程优先级
        c.setPriority(Thread.MIN_PRIORITY); //设置最小的线程优先级
//      7.同步代码块 开启多线程后 所有代码的执行都会交替运行
//        在实际应用过程中 我需要完整的执行一块代码 而不是来回切换
        synchronized (new Object()){
//            code xxxxxxx 同步锁关键字 参数 任意对象 任意对象！！任意对象！
        }
//      8.同步方法
        new Thread() {
            @Override
            public synchronized void run() {
                while (true) System.out.println("我是线程1");
            }
        };
//      细节：同步锁的对象是谁？
//      静态方法分析：
        new Thread() {
            @Override
            public void run() {
                while (true)
                    Test.printLi();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true)
                    Test.printTang();
            }
        }.start();
//      经过测试在静态方法中 锁的对象是 字节码文件 也就是本类的Class
//      非静态方法分析：
        final Test test = new Test();
        new Thread() {
            @Override
            public void run() {
                while (true)
                    test.printL();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true)
                    test.printT();
            }
        }.start();
//      经过分析非静态方法中锁的对象是this
//      一个坑点 同步对象都传new Object 是不好使的 因为new出来的东西不是一个东西
//      是锁不住的！！！！！！ 想锁住 建议直接传类.class
//      9.线程安全问题
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
//      线程运行中代码对同一个变量修改操作时 一旦发生轮替 那么变量就不一定是最初的变量
//      所以在编写代码时 多线程对同一个变量操作时 一定要加上同一个同步锁 才能保证数据安全
//      另外注意 多次启动一个线程是非法的！！！
//      10.线程运行中的死锁
        DeadLock.run();
//      建议不要同步锁嵌套着写！！！
//      11.java中常见的线程安全类
        Vector<String> vector = new Vector<String>();
        StringBuffer buffer = new StringBuffer();
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
//        Collections.synchronizedXXXXX;
    }
}
class DeadLock{
    public static String s1 = "11";
    public static String s2 = "12";
    public static void run(){
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    System.out.println(getName()+"拿到s1, 等待s2");
                    synchronized (s2){
                        System.out.println(getName()+"拿到s2, 释放s1s2");
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (s2){
                    System.out.println(getName()+"拿到s2, 等待s1");
                    synchronized (s1){
                        System.out.println(getName()+"拿到s1, 释放s2s1");
                    }
                }
            }
        }.start();
    }
}
class Ticket extends Thread{
    public static int number = 100;
    @Override
    public void run() {
        synchronized (Ticket.class){
            System.out.println(getName()+"---正在卖 第 "+(number--)+ "号票");
        }
    }
}
class Test{

    public static synchronized void printLi() {
        System.out.print("我");
        System.out.print("叫");
        System.out.print("李");
        System.out.print("金");
        System.out.print("玉");
        System.out.println();
    }
    public static synchronized void printTang() {
        System.out.print("你");
        System.out.print("是");
        System.out.print("唐");
        System.out.print("珑");
        System.out.print("铭");
        System.out.println();
    }
    public void printL() {
        synchronized (Object.class){
            System.out.print("我");
            System.out.print("叫");
            System.out.print("李");
            System.out.print("金");
            System.out.print("玉");
            System.out.println();
        }

    }
    public void printT() {
        synchronized (Object.class){
            System.out.print("你");
            System.out.print("是");
            System.out.print("唐");
            System.out.print("珑");
            System.out.print("铭");
            System.out.println();
        }

    }
}
class MyThread extends Thread{
    String name;
    MyThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        while (true) System.out.println("我是"+name);
    }
}
class MyRunnable implements Runnable{
    String name;
    MyRunnable(String name){
        this.name = name;
    }
    public void run() {
        while (true) System.out.println("我是"+name);
    }
}