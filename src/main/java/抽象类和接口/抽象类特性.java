package 抽象类和接口;

public class 抽象类特性 extends People{ //知识点1：抽象类是为了被继承而存在 需用exteds修饰
    public static void main(String[] args) {
        People people = new 抽象类特性();
        //People people = new People();
//        People people = new People() {
//            @Override
//            void go() {
//
//            }
//        }
        people.go();
        //知识点2：抽象类不能被实例化 如果想实例化 1.实例化实现类 2.重写抽象类里面的所有抽象方法
    }

    @Override
    void go() {
        System.out.println("我正在奔跑");
    }

    @Override
    void eat() {
        System.out.println("我正在吃饭");
    }

    @Override
    public void cut() {
        System.out.println("我正在砍东西");
    }
}
abstract class People extends Biology{  //知识点：抽象类允许继承抽象类
    //知识点1：如果这个类有抽象方法 那么这个类一定是抽象类 但是抽象类不一定有抽象方法 必须使用 abstract 关键字修饰
    abstract void  go(); //知识点2：抽象方法必须使用 abstract 关键字修饰
    //知识点2：抽象方法 只能用public或protected 修饰
}
abstract class Biology implements Arams{ //知识点1：抽象类可以实现接口
    abstract void eat();
    Biology(){
    }
}
interface Arams{
    void cut();
}
/*
    1.在接口中 8版本后  default 和static 修饰的方法可以有方法体
    2.抽象类中 是可以有构造函数的！！！！！

 */