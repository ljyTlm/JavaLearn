package 常用工具类;

public class Integer类 {
    public static void main(String[] args) {
//        就一个知识点！！！
//        java有个常量池 储存着 -128到127的常量
//        -128到127是byte的表示范围
        Integer a = 123;
        Integer b = 123;
        System.out.println(a == b);
        Integer c = 127;
        Integer d = 127;
        Integer e = 128;
        Integer f = 128;
        System.out.println(c == d);
        System.out.println(e == f);
    }
}
