package 初始化和清理;

public class 初始化样例 {
    public static void main(String[] args) {
        String str = "初始化和清理";
        //知识点：字符串初始化推荐使用直接赋值 因为new的东西占内存 直接赋值的话 会调用字符串的常量池
        Integer a = 1;
        //知识点：Integer直接赋值比较有意思 为了减少小而常用的数值频繁的创建 在-127-128会直接从缓冲池里拿取
        //Node node = new Node();
        //知识点：对象的初始化流程是：当前类-->父类---。。。--->顶类 构造方法---->父类 构造方法---->最后调用当前类的构造方法
        //知识点：对象初始化时在构造方法里面 使用super必须放在第一行
        //知识点：对象初始化时或者调用静态成员时 优先执行静态代码块只调用一次 有继承的时候 也是先从顶类在到当前类的执行顺序
        //知识点：大家都是静态成员时 那就按照代码的书写顺序执行
    }
}
class FatherFatherNode{
    static {
        System.out.println("我是爷爷辈的静态代码块");
    }
    FatherFatherNode(){
        System.out.println("我是爷爷");
    }
}
class FatherNode extends FatherFatherNode{
    static {
        System.out.println("我是爸爸辈的静态代码块");
    }
    FatherNode(){
        System.out.println("我是爸爸");
    }
    void get(){}
}
class Node extends FatherNode{
    static {
        System.out.println("我是静态代码块");
    }
    static int a = 10;
    Node(){
        System.out.println("我是儿子");
    }
    void add(){}
    static void set(){}
}
