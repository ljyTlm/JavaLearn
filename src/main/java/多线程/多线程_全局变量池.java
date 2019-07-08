package 多线程;

public class 多线程_全局变量池 {
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocal map = new ThreadLocal();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                map.set("2");
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                map.set("3");
            }
        };
        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        System.out.println(map.get());
    }
}
/*
    1.ThreadLocal用来在本线程内共享变量
    2.底层是ThreadLocalMap
    3.原理就是在Thread中保存一个ThreaLocalMap

 */