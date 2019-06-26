package 输入输出流;

import java.io.*;

public class 数据流样例 {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("x.txt"));
//      数据输入流 用来读int long double 等值
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("k.txt"));
//      数据输出流 用来写入 int long double 等值
//      为什么要单独列出来这个类呢 主要是为了解决 字节溢出的问题
//      因为写入的时候是按字节写入 一个字节八位 超过八位的 会被程序砍掉 这个值就被破坏掉了
        int data = dataInputStream.readInt();
        dataOutputStream.writeInt(data);
    }
}
