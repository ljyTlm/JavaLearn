import java.lang.ref.WeakReference;

public class Main {

    volatile int a;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    WeakReference reference = new WeakReference(new Object());
                }
            }
        }.start();
    }
}


