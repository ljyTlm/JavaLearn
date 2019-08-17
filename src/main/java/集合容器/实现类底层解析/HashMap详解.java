package 集合容器.实现类底层解析;

import java.util.HashMap;

public class HashMap详解 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "");
        hashMap.get(2);
    }
}
/**
 *      1.put操作
 *          1.计算hash
 *          2.判断hashtable 长度
 *          3.判断hash冲突
 *          4.不冲突就直接插入
 *          5.冲突的话 先判断当前是否是红黑树
 *          6.是红黑树就以红黑树的方式插入
 *          7.不是红黑树，就循环链表，进行更新或者插入
 *          8.判断当前容量是否需要扩容
 *      2.resize 操作
 *          1.浅拷贝当前hash表 作为老hash表
 *          2.然后扩大两倍 新建新hash表
 *          3.循环老hash表，然后计算每个桶在新hash表的位置
 *          4.重点是计算的过程中加了一个优化 因为每次都是2的n次幂大小
 *            2进制位第一个1后面的位置如果是0那么说明不用动 如果是1大小直接加老的大小
 *      3.get操作
 *          没啥可说的
 *
 * */
