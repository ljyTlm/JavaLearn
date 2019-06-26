package 输入输出流;

import java.io.*;

public class Bufferedy样例 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("in.txt"));
        BufferedOutputStream ou = new BufferedOutputStream(new FileOutputStream("ou.txt"));
        int b;
        while ((b = in.read()) != -1){
            ou.write(b);
        }
//      这两个类封装了基础的输入输出流 使其变得更加强大（高效率）
//      虽然代码上还是一个一个读 但是这个封装了一个缓冲区 大小为8192
//      当超过这个大小才会序列化的磁盘 其余操作都是在内存操作
        ou.flush();
//      此方法刷新缓冲区 也就是写入磁盘 close方法具备同样的功能
//      但是用了close方法 流就关闭了 再用就会抛异常
        in.close();
        ou.close();
//      只关闭包装类就好
    }
}
