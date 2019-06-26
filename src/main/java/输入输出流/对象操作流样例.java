package 输入输出流;

import java.io.*;
import java.util.ArrayList;

public class 对象操作流样例 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("x.txt"));
//      从磁盘读数据的过程叫做 反序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("v.txt"));
//      从内存向磁盘写数据叫做 序列化

//      直观的举例就是游戏存档

        Object o = inputStream.readObject();
        outputStream.writeObject(o);
//      此时会报错 因为Object并没有实现序列化接口
//      这个就是java中的约定 实现了这个接口就可以序列化 没实现就报错
//      接口的名字叫做：Serializable
        ArrayList<Object> list = new ArrayList<>();
        outputStream.writeObject(list);
    }
}
