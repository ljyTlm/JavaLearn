package 输入输出流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class 标准流样例 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        PrintStream out = System.out;
//      标准输入输出流
        in.close();
        System.in.read();
//      此时报错 因为 你把in已经关掉了
        System.setIn(new FileInputStream("x.txt"));
//      默认指向的是键盘 从键盘读入字符串 而现在指向文件
        System.setOut(new PrintStream("t.txt"));
        System.out.println("adsfa");
//      此时就不是控制台输出了 会直接输出到指定的文件中 默认指向控制台
//      标准流是不需要关的 因为他们都是在内存中操作并没有和文件关联上
    }
}
