package 输入输出流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class 序列流样例 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream1 = new FileInputStream("kk.txt");
        FileInputStream fileInputStream2 = new FileInputStream("kk.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
//      SequenceInputStream 这个就是序列流的类 用于整合字节流 就是两个流合并成一个流
//      枚举整合多个流
        Vector<FileInputStream> v = new Vector<>();
        v.add(new FileInputStream("1.txt"));
        v.add(new FileInputStream("2.txt"));
        v.add(new FileInputStream("3.txt"));
        Enumeration<FileInputStream> elements = v.elements();
        sequenceInputStream = new SequenceInputStream(elements);
    }
}
