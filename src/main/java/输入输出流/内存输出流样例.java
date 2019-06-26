package 输入输出流;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class 内存输出流样例 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        public ByteArrayOutputStream() {
//        this(32);
//    }
//        这是构造方法的源码 默认是32 的大小
//        这个虽然称为流但实际不是与磁盘相连接 而是在内存中开辟了 byte数组 随着写入数据而增大
        String s = byteArrayOutputStream.toString();
//        提供了直接将byte数组传承字符串的功能
        byte[] bytes = byteArrayOutputStream.toByteArray();
//        也提供了获取byte数组的方法 这样我们就可以
        String str = new String(bytes, "utf-8");
//        自己指定编码方式 不然toString用的平台默认方法
    }
}
