package 常用工具类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Collections类 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.sort(list); //集合排序 只要是List的子类就行
//      这个排序是个坑 实际调用的 Arrays.sort 源码中只是先把集合转成数组 然后排序 然后利用set逐一更新值
        Collections.binarySearch(list, "p");
//      经典的二分搜索 使用前要将集合排序 不然结果不稳定
//      如果找到了就返回索引值 不然就返回 -插入点-1
        Collections.max(list);
//      获取集合中的最大值 看完源码 感觉并不高深 遍历所有找出最大值 常规操作
        Collections.reverse(list);
//      list instanceof RandomAccess
//      用instanceof关键字判断此类是否实现了RandomAccess接口
//      这个接口啥也没有 但是源码中却判断了并根据有没有 实现不同的迭代方式
//      原因就是 ArrayList用for快 LinkedLIst用Iterator快
        Collections.shuffle(list);
//      此方法会将集合元素随机置换 底层源码就是随机交换元素 这个随机规则可以自己指定
    }
}
