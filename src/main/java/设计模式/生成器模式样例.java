package 设计模式;

public class 生成器模式样例 {
    public static void main(String[] args) {
//      1.生成器模式概述
//        生成器模式可以帮助我们创建对象
//        工厂模式也可以帮助我们创建对象两者的区别在那呢 为什么要有生成器模式
//        原因:当我们需要创建复杂对象时工厂模式已经不适用了 因为对象很复杂
//        我们需要精细的控制其中的逻辑 而且利用该类的构造方法创建的对象已经无法满足需求时
//      2.生成器模式要素
//        1.产品
//        2.生成器接口
//        3.生成器实现类
//        4.指挥者类也叫指导者 导向者
        FuTeBuilder fuTeBuilder = new FuTeBuilder();
        DirectorCar directorCar = new DirectorCar(fuTeBuilder);
        directorCar.prodoce();
        System.out.println(directorCar.getCar());
//      3.按照我所理解的就是 使用构造方法会将一个个性化定制的遗留在类中 臃肿混乱
//        而生成器模式 可以不初始化的东西抽成方法 然后指定方法调用顺序 就可以定制复杂对象
//
    }
}

/**
 * 产品 汽车
 */
class Car {

    String name;

    int weight;

    @Override
    public String toString() {
        return name+"   "+weight;
    }
}

/**
 * 生成器接口
 */
interface Builder {

    void setName(String name);

    void setWeight(int weight);

    Car getCar();
}

/**
 * 生成器实现类
 */
class FuTeBuilder implements Builder {

    Car car;

    FuTeBuilder() {
        car = new Car();
    }

    @Override
    public void setName(String name) {
        car.name = name;
    }

    @Override
    public void setWeight(int weight) {
        car.weight = weight;
    }

    @Override
    public Car getCar() {
        return car;
    }
}

class DirectorCar {
    Builder builder;

    DirectorCar() {}

    DirectorCar(Builder builder) {
        this.builder = builder;
    }

    Car getCar() {
        return builder.getCar();
    }

    public void prodoce() {
        builder.setName("福特");
        builder.setWeight(100);
    }
}
