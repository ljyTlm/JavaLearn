import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    volatile static int a;

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                a ++;
            }
        };
    }

}