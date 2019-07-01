package 泛型;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 泛型样例 {
    public static void main(String[] args) {
//        1.在以前处理多对象时使用object进行强转 但是存在隐患 随后jdk引入泛型
//        2.泛型的写法 使用菱形符号 在jdk7后 后面的可以不用写类型
//        3.主要分为两种 类泛型 和 方法泛型
//        4.静态方法使用泛型 必须自己指定泛型 不能使用当前类的泛型
//        5.泛型接口 实现的时候指定泛型 重写方法时就是指定的类型 不推荐实现泛型接口时自己再去指定泛型
//        6.泛型通配符<?>
//          1.默认<?> 代表一切类型 包括Object和他的子类
//          2.<? super T> 固定下边界
//          3.<? extends T> 固定上边界
//        7.泛型默认是object类型 里面只有Object的方法 如果想调用指定的方法
//          那么我们必须抽取出通用的方法 比如我们想做泛型的比较

        MyGeneric<String> myGeneric1 = new MyGeneric<String>();
        MyGeneric<String> myGeneric2 = new MyGeneric<>();

//      演示固定上边界 所传的类型只能是当前指定类的子类
        List<Integer> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        test(list1);
        test(list2);
//      演示固定下边界 解释：单签所指定的泛型必须是当前类型或者超类也就是父类
        List<Number> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        test2(list3);
        test2(list4);
    }

    private static void test2(List<? super Integer> list3) {
    }

    private static void test(List<? extends Number> list1) {
//        设置通配符只接受父类是number的对象
    }
}
class MyGeneric<T> {

    public T getVal() {
        T v = (T) new Object();
        return v;
    }

    public <E> void setVal(E v) {

    }

    public static <R> void getObj(R p) {

    }
}