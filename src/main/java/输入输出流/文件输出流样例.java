package 输入输出流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class 文件输出流样例 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream out = new FileOutputStream("tt.txt");
//      指定输出路径 没有的话会帮我们自动创建
//      如果有的话 在写入的时候 会清空原有的内容 然后再进行追加 不过可以设置
        out = new FileOutputStream("tt.txt", true);
    }
}
