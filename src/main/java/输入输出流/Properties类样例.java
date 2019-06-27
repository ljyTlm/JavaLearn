package 输入输出流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Properties类样例 {
    public static void main(String[] args) throws IOException {
//        这个类专门用来读取配置文件 配置文件一般存储的就是持久属性
        Properties properties = new Properties();
        properties.put("1", "2");
        properties.setProperty("abc", "123");
        Enumeration<String> enumeration = (Enumeration<String>)properties.propertyNames();
//      获取枚举类型 我们就可以遍历key的集合
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
        }
        properties.load(new FileInputStream("x.txt"));
//      从流中加载 磁盘文件信息
        properties.store(new FileWriter("t.txt"), "这里是注释");
//      修改属性后向磁盘写入修改后的内容 第二个参数是注释
    }
}
