package 集合容器;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;

public class Set样例 {
    public static void main(String[] args) {
//      1.HashSet
//        特点：无重复 无索引 无序存储
        HashSet<String> hashSet = new HashSet<>();
//        HashSet如果保证值唯一？
//        当向HashSet添加元素是 首先会获取hashcode入过没有 则直接存入
//        如果相同则调用equal方法逐一比较
//        所以当自定义对象是 一定重写equal和hashcode方法
//        然而实际的过程中 这两个方法 ide直接帮我们重写
//        从1.5版本之后 Arrays工具类提供了 多个对象生成hashcode的方法
//        这个方法的底层也是选用31这个数字 因为31是一个质数 说大不大 说小不小 2的五次方减1 好算

//      2.LinkedHashSet
//        特点：无重复 无索引 set集合中唯一一个有序存储 底层链表实现
//        LinkedHashSet 的大部分方法来自 HashSet 然后HashSet有个构造器是专门给LinkedHashSet的
//        通过查看源码 这个构造在new 的时候使用的LinkedHashMap
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

//      3.TreeSet
//        特点：无重复 无索引 排序存储 底层树实现
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student());
//        存储的元素必须实现Comparable接口 或者指定比较器
//        1.to方法返回 0  只有一个元素会被存储
//        2.to方法返回 正 按照插入顺序排
//        3.to方法返回 负 按照插入顺序倒序排
//        自然排序：Comparable接口
//        比较器排序优先 Comparable接口
//        再源码中可以清晰的看到 先判断有没有比较器在进行比较
    }
}
class Student {
    String name;

    int age;


}
