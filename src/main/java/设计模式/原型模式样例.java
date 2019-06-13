package 设计模式;

import java.util.HashMap;

public class 原型模式样例 {
    public static void main(String[] args) {
//        1.原型模式特性
//          制造一个原型 对原型进行复制后 新的类和原型并不互相干扰
//        2.原型模式有什好处
//          主要是解决一个类需要反复的创建 new的过程特消耗资源的这种
//          使用原型模式后 直接克隆
//        3.原型模式的写法 必须必须实现 Cloneable 接口。
            Bullet bullet = ModelFactory.getModel("1");
            System.out.println(bullet.name);
            bullet.name = "hhh";
            System.out.println(bullet.name);
            ModelFactory.print("1");
    }
}
class ModelFactory{
    private static HashMap<String, Bullet> map;
    static {
        map = new HashMap<String, Bullet>();
        map.put("1", new Bullet("我是金子弹"));
        map.put("2", new Bullet("我是银子弹"));
        map.put("3", new Bullet("我是铜子弹"));
    }
    public static Bullet getModel(String id){
        Bullet val = map.get(id);
        return (Bullet) val.clone();
    }
    public static void print(String id){
        System.out.println(map.get(id).name);
    }
}
class Bullet implements Cloneable{
    @Override
    protected Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public String name;

    Bullet(){}

    Bullet(String name){
        this.name = name;
    }

}