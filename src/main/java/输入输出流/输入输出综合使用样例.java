package 输入输出流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 输入输出综合使用样例 {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("in.txt");
        FileOutputStream out = new FileOutputStream("out.txt");
//      1.一个一个读 时间慢
        out.write(input.read());
//      2.先全部加入到内存中 在写入 不推荐 容易造成内存泄露
        int len = input.available();
        byte [] b = new byte[len];
        input.read(b);
        out.write(b);
//      3.小数组读入 推荐！ 小数组推荐1024的整数倍 大小 1024*8 8k
        byte [] bytes = new byte[10];
        int k;
        while ((k = input.read(bytes)) != -1){
            out.write(bytes, 0, k);
        }
//      4.读入中文时会产生问题
//        不同的码表中文占的字节个数不一样 一个一个字节读很容易产生问题
//        不过写入的时候可以正常写 但是必须获取字符串的byte数组
        out.write("我叫李金玉".getBytes());
//      5.关流操作
//        老版本的写法
        try {
//          xxxxxxxxxx
        }finally {
            try {
                input.close();
            }finally {
                out.close();
            }
        }
//        新版本的写法
        try (
            FileInputStream p = new FileInputStream("in.txt");
            FileOutputStream o = new FileOutputStream("out.txt");
        ){
//            xxxxxxxxxxxxxxx
        }
    }
}
