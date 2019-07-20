import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;




public class Main {

    public static final Main m = new Main();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int a = 100;
                while (a-->0) {
                    System.out.println("1");
                    try {
                        sleep(100);
                    }catch (Exception e) {
                    }
                }
                System.out.println("线程1执行完毕");
                m.unlock();
            }
        }.start();
        m.lock();
        new Thread() {
            @Override
            public void run() {
                int a = 100;
                while (a-->0) {
                    System.out.println("2");
                    try {
                        sleep(100);
                    }catch (Exception e) {
                    }
                }
                System.out.println("线程2执行完毕");
                m.unlock();
            }
        }.start();
        m.lock();
        new Thread() {
            @Override
            public void run() {
                int a = 100;
                while (a-->0) {
                    System.out.println("3");
                    try {
                        sleep(100);
                    }catch (Exception e) {
                    }
                }
                System.out.println("线程3执行完毕");
                m.unlock();
            }
        }.start();
        m.lock();
    }

    private final synchronized void unlock() {
        try {
            notify();
        }catch (Exception e) {

        }
    }


    public final synchronized Integer lock() {
        try {
            wait(0);
        }catch (Exception e) {

        }

        return null;
    }

}
class A {
    @Override
    public String toString() {
        return "a";
    }
}
class B extends A{
    @Override
    public String toString() {
        return "b";
    }
}
