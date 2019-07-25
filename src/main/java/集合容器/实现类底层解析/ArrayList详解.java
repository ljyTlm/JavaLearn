package 集合容器.实现类底层解析;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList详解 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.clone();
    }
}
/*
    1.ArrayList的大小是如何自增的？
        当向ArrayList中添加元素时，首先会先检测空间够不够，如果不够则扩容
        扩大0.5倍，调取Arrays.copyOf方法将原来的元素复制到新空间
        最终的底层是调用System.arraycopy 这是一个本地方法 native修饰的
    2.如何复制一个ArrayList到另外一个ArrayList
        三种方法
        1.使用ArrayList的构造器 浅拷贝
        2.使用ArrayList.clone()方法 浅拷贝
        3.Collection.copy方法 底层使用迭代器for循环

 */
