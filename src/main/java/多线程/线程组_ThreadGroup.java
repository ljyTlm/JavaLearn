package 多线程;

public class 线程组_ThreadGroup {
    public static void main(String[] args) {
//        java允许程序直接对线程组进行操作
//        java提供了ThreadGroup 默认情况下所有线程都属于主线程组
        System.out.println(Thread.currentThread().getName());
        ThreadGroup group = new ThreadGroup("我是新的线程组");
        Thread thread1 = new Thread(group ,new GroupTest(),"张三");
        Thread thread2 = new Thread(group ,new GroupTest(),"李四");
        Thread thread3 = new Thread(group ,new GroupTest(),"王五");

        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        System.out.println(thread3.getThreadGroup().getName());

        group.setDaemon(true);
//      成组操作方便省事 整个组都变成了守护线程

    }
}
class GroupTest implements Runnable{
    public void run() {
        for (int i = 0; i < 10000; i ++){
            System.out.println(Thread.currentThread().getName()+"---runTime!---"+i);
        }
    }
}
