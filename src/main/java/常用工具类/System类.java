package 常用工具类;

import java.io.InputStream;
import java.io.PrintStream;

public class System类 {
    public static void main(String[] args) {
//        System类 提供很对针对操作系统的方法
//        主要有三个字段
        InputStream in = System.in;
        PrintStream out = System.out;
        PrintStream err = System.err;
//        几大方法
        System.gc();
//        运行垃圾回收器
        System.exit(0);
//        终止当前运行的虚拟机 根据惯例 非0的状态码 表示异常终止
        long l = System.currentTimeMillis();
//        返回以毫秒为单位的系统时间
        int [] src = {1, 2, 3, 4, 5};
        int [] arr = new int[100];
        System.arraycopy(src, 0, arr, 3, src.length);
//        拷贝数组
    }
}
