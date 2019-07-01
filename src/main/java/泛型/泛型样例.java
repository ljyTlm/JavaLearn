package 泛型;

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
//          2.<? super T> 向上限定
//          3.<? extends T> 向下限定
//        7.泛型默认是object类型 里面只有Object的方法 如果想调用指定的方法
//          那么我们必须抽取出通用的方法 比如我们想做泛型的比较

        MyGeneric<String> myGeneric1 = new MyGeneric<String>();
        MyGeneric<String> myGeneric2 = new MyGeneric<>();
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