package 设计模式;

public class 模板模式样例 {
    public static void main(String[] args) {
//      给好固定的框架 使用者可以通过重写 自定义扩展
        Father a = new Child();
        a.function_do(new Object());
    }
}
class Father {
    public void function_1(Object object) {

    }

    public void function_2(Object object) {
        System.out.println("正在执行");
    }

    public void function_3(Object object) {

    }

    public void function_do(Object object) {
        function_1(object);
        function_2(object);
        function_3(object);
    }
}
class Child extends Father {
    @Override
    public void function_1(Object object) {
        System.out.println("我是方法1");
    }

    @Override
    public void function_3(Object object) {
        System.out.println("我是方法3");
    }
}