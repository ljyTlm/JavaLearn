package 多线程;

public class 线程安全样例 {
    static volatile boolean[] bool = {false};
    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                }catch (Exception e) {

                }
                bool[0] = true;
                System.out.println("1 over");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (!bool[0]) {

                }
                System.out.println("2 over");
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
//      说明上面的操作 线程2 会停不下来来 这是因为java中线程模型的结构所造成的的
//      线程------高速缓存副本------虚 ----read----系
//      线程------高速缓存副本------拟
//      线程------高速缓存副本------机 ----write---统
//      原因就是 中间夹着一层 缓存 读的时候读的任然是缓存false所以一直不结束
//      这种称为可见性问题 java推出了volatile关键字 加上此修饰符的对象  在别人访问时一定
//      要找最新的值 无论读还是写 这里引入一个新名词叫内存屏障 这个关键字还可以指定jvm不允许对
//      指令进行重排 还有一点这个指令重排问题会导致单例模式失效 所以一般单例模式对象要加volatile关键字
//      内存屏障有三种类型和一种伪类型：
//
//      a、lfence：即读屏障(Load Barrier)，在读指令前插入读屏障，可以让高速缓存中的数据失效，重新从主内存加载数据，以保证读取的是最新的数据。
//      b、sfence：即写屏障(Store Barrier)，在写指令之后插入写屏障，能让写入缓存的最新数据写回到主内存，以保证写入的数据立刻对其他线程可见。
//      c、mfence，即全能屏障，具备ifence和sfence的能力。
//      d、Lock前缀：Lock不是一种内存屏障，但是它能完成类似全能型内存屏障的功能。

    }
}
