package 常用工具类;

public class Math类 {
    public static void main(String[] args) {
//        直接上方法！！
        int v_1 = Math.abs(-1);
        int v_2 = Math.min(5, 6);
        int v_3 = Math.max(5, 6);
        int v_4 = (int)Math.round(5.5);
//      注意这个四舍五入的方法
        System.out.println(v_4);
        int v_5 = (int)Math.round(-5.5);
        System.out.println(v_5);
        int v_6 = (int)Math.round(-5.6);
//      实验表明 负数的四舍五入 四其实代表的是6
        System.out.println(v_6);
        double v_7 = Math.floor(5.1);
        System.out.println(v_7);
        double v_8 = Math.floor(-5.1);
        System.out.println(v_8);
//      floor()向下取整！！！！
        double v_9 = Math.ceil(7.5);
        System.out.println(v_9);
//      ceil向上取整
    }
}
