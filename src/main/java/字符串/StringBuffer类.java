package 字符串;

import java.sql.Time;
import java.util.Date;

public class StringBuffer类 {
    public static void main(String[] args) {
//        1.StringBuffer类概述
//          该类是一个线程安全的可变字符序列 类似String的缓冲区
//        2.StringBuffer的创建
            StringBuffer b1 = new StringBuffer();
            StringBuffer b2 = new StringBuffer(16);
            StringBuffer b3 = new StringBuffer("555");
            StringBuffer b4 = new StringBuffer(new StringBuilder());
//        3.StringBuffer的常用方法
            b1.append(new Date());
            b1.insert(1, new Date());
            System.out.println(b1);
//          注意这个方法可以添加任意类型！！！
            b1.delete(2, 3);
            b1.deleteCharAt(6);
            System.out.println(b1);
            b1.replace(6, 7, "adfa");
            System.out.println(b1);
            b1.reverse();
            System.out.println(b1);
            String b5 = b1.substring(7);
            System.out.println(b5);
            String b6 = b1.substring(4, 9);
            System.out.println(b6);
//        4.StringBuffer 和 StringBuilder 的区别
//          StringBuffer是jdk1.0版本的 是线程安全的 效率低
//          StringBuilder是jdk1.5版本的 是线程不安全的 效率高
//        5.参数传递中的一些细节
            String b7 = "dasfa";
            change(b7);
            System.out.println(b7);
            String b8 = new String("567");
            change(b8);
            System.out.println(b8);
//          可以看到b7的值并没有被改变 String虽然是引用数据类型 但被当做参数传递时和基础数据类型一样
            StringBuffer b9 = new StringBuffer("qwe");
            change(b9);
            System.out.println(b9);
    }

    private static void change(StringBuffer b9) {
        b9.append("asd");
    }

    private static void change(String b7) {
        b7 += "weew";
    }
}
