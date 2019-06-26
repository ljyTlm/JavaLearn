package 输入输出流;

import java.io.*;

public class 字符流样例 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("s.txt");
        int read = reader.read();
//      这个类继承自 InputStreamReader 顶层类是 Reader 类
        BufferedReader bufferedReader = new BufferedReader(reader);
//      使用了装饰模式对字符流提供了更强大的功能
//      1.常用方法
        bufferedReader.readLine();
//      读取一行
        bufferedReader.ready();
//      详细的解释 待定

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("kk.txt"));
        bufferedWriter.newLine();
//      这个方法的作用是重起一行 \r\n 的作用是相同的 那为什么会有这个方法 因为这个方法是全平台通用的
//      \r\n只支持windows \rMac \n linux

        LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
        lineNumberReader.setLineNumber(100);
        lineNumberReader.getLineNumber();

    }
}
