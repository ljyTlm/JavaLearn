package 设计模式;

public class 委托模式样例 {
    public static void main(String[] args) {
//      1.委托模式特性
//        隐藏细节 暴露在外面的接口 并不负责具体的实现任务
//        干活是员工的 功劳是领导的
        Boos boos = new Boos();
        boos.doIng();
    }
}
interface Work{
    void doIng();
}
class Boos implements Work{

    public static Staff staffA = new Staff("A");

    public void doIng() {
        staffA.doIng();
    }
}
class Staff implements Work{

    String name;
    Staff(){}
    Staff(String name){
        this.name = name;
    }

    public void doIng() {
        System.out.println(this.name+"员工正在工作");
    }
}