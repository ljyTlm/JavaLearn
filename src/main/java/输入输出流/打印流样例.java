package 输入输出流;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class 打印流样例 {
    public static void main(String[] args) throws FileNotFoundException {
//      该流可以自动调用对象的toString方法将其输出 并且加上自动换行 而且可以使用自动刷出模式
        System.out.println("aaa");
        PrintStream printStream = System.out;
        printStream.println("sdfasd");
//      打印字节流

        PrintWriter printWriter = new PrintWriter("x.txt");
        printWriter.println(98);
        printWriter.write(56);
//      打印字符流
//      当使用write方法的时候 数据仍在缓冲区
//      但是当使用println的时候 就会自动刷新缓冲区 也就是换行
    }
}
