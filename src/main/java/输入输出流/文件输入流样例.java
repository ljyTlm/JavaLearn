package 输入输出流;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class 文件输入流样例 {
    public static void main(String[] args) throws IOException {
        FileInputStream input_1 = new FileInputStream("tt.txt");
        int a = input_1.read();
//      read()方法是读取字节 一个字节的取值范围是 -128 - 127 为什么吗不用byte呢？
//      文件读取结束的标志是 -1 在机器中 -1 存储是用补码 11111111 遇到这样就会读一半就停止
        byte [] b = new byte[10];
        int c = input_1.read(b);
//      尽可能的读文件 读取的内容存到了数组中 c返回的是读取了多少个字节
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//      存在这样一个问题 数组的大小是 10 那如果文件字节不能整除10 最后只能读6个
//      数组剩下的空间存啥了？ 答：乱码 常见的就是问号
//      这时我们可以采用这个字节缓冲区
        outStream.write(b, 0, 6);
//      将剩下的字符存到缓冲区
        byte[] bytes = outStream.toByteArray();
//      取出缓冲区的所有字符
    }
}
