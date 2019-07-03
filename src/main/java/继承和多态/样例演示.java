package 继承和多态;

public class 样例演示 {
    public static void main(String[] args) {
        Father obj = new Child();
        obj.eat();
        //知识点：多态的定义 就是同一个行为多种的表现形式
//        知识点：最大的好处就是消除耦合 可以有一个标准化的接口 在不同的上下文中实现这个接口
//        就可以指定不同的功能 例如在不同的窗口按相同的键子 所产生的结果是不同的 如果没有多态这个特性
//        很显然 程序就写死了 也就是极度耦合
//        知识点：继承是多态的表现 实例是方法的重写 调用就是父类的引用指向子类的对象
//        知识点：当子类和父类同变量名时， 子类会覆盖或隐藏父类的变量
    }
}

class Father{
    private String name;

    void eat(){
        System.out.println("我吃的是米饭");
    }

    //知识点：实现et和set方法实现对私有属性的封装
//    好处：1.向外界隐藏实现细节 使数据更加安全
//         2.降低程序的耦合 当需要修改属性时 并不需要修改外界的代码 只需要改动当前类就可以了
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Child extends Father{
    @Override
    void eat() { //这种就是方法的重写 跟父类同名同参数
        System.out.println("我吃的是奶粉");
    }

    void eat(String food){ //这种就是方法的重载 同名不同参数
        System.out.println("我吃的是"+food);
    }
}