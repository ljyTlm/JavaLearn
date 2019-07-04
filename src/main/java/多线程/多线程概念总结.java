package 多线程;

public class 多线程概念总结 {
    public static void main(String[] args) {

        final Object obj1 = new Object();
        final Object obj2 = new Object();
        final Object obj3 = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("我是线程1");
                obj2.notifyAll();
            }
        };

        Thread thread2= new Thread() {
            @Override
            public void run() {
                synchronized (obj2) {
                    try {
                        obj2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是线程2");
                    obj3.notifyAll();
                }

            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                synchronized (obj3) {
                    try {
                        obj3.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是线程3");
                }

            }
        };

        thread3.start();
        thread2.start();
        thread1.start();
    }


}
/*
    1.






 */