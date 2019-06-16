package 常用工具类;

import java.util.Random;

public class Random类 {
    public static void main(String[] args) {
//        Random用于生成伪随机数
        Random random_1 = new Random();
        int v_1 = random_1.nextInt();
        System.out.println(v_1);
        Random random_2 = new Random(100);
        int v_2 = random_2.nextInt();
        System.out.println(v_2);
//      随机数是根据种子进行计算的 可以自己指定种子
//      默认的种子是系统的纳秒值
        int v_3 = random_2.nextInt(100);
        System.out.println(v_3);
//      生成指定范围内的随机数
//      那如果想生成40-70呢？
        int v_4 = 40+random_2.nextInt(30);
        System.out.println(v_4);
    }
}
