package 多线程;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class 多线程_Timer样例 {
    public static void main(String[] args) throws InterruptedException {
//        Timer 计时器类
        Timer timer = new Timer();
//      指定时间启动线程
        timer.schedule(new MyTimerTask(), new Date());
//      指定时间 和 循环时间 循环启动线程
        timer.schedule(new MyTimerTask(), new Date(), 3000);
        while (true){
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }

}
class MyTimerTask extends TimerTask{

    public void run() {
        System.out.println("线程启动啦~~");
    }
}