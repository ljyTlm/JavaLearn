package 虚拟机;

public class 关键字总结 {


    public static void main(String[] args) throws Exception{
        final int [] a = {1};
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (Object.class) {
                    a[0] = 2;
                    String b = null;
                    b.toString();
                }
            }
        };
        thread.start();
        thread.join();
        Thread.sleep(2000);
        System.out.println(a[0]);
    }

}

/*
    1.final
        （1）final修饰类
            表示此类不能被继承 其内部的方法隐式为final方法
        （2）final修饰方法
            final修饰的方法不能被重写 但是可以被重载
        （3）final修饰变量
            final修饰的变量必须进行初始化，而且只能初始化一次
            可以进行直接初始化，不然只能在所有的构造方法中初始化
            注意：这个变量不能重新赋值，但是可以修改变量
        （4）final不能修饰接口和抽象类
    2.volatile
        (1)禁止指令重排 jvm虚拟机在执行代码时 会对执行指令进行优化
           加入这个关键字 会在操作这个关键字之前和之后加入四个屏障
           写：StoreStore 写后：StoreLoad
           读：LoadLoad   读后：LoadStore
           没有任何的安全感 属于悲观锁
        (2)保证数据的可见性 因为jvm在执行的过程中加了上述指令
           所以每一次的数据都是直接作用在内存中读和取 缓冲区失效
        (3)此关键字可以看为一种轻量级的sync 实现了锁的 可见性
           但是没有实现锁的 ！！！ 原子性 ！！！！也就是不会引起线程阻塞
           存在安全问题 多线程的计数器功能无法实现 ！！！
    3.synchronized
        (1)可重入性 在调取方法时 调取的方法自动获取当前使用的锁
        (2)不可中断性/原子性 一旦这个锁被某个线程获取 除非锁被释放 不然其他想获取这个锁的线程只能等待
           进入等锁池
        (3)效率低 除非同步代码块执行不然是不会释放锁的
        (4)无法知道是否成功获取到锁

 */
