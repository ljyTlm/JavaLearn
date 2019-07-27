package 设计模式;

public class 门面模式样例 {
    public static void main(String[] args) {
//      门面模式的核心思想就是动里不动外
//      由门面负责对客户隐藏细节
//      门面模式典型的应用就是日志系统
//      阿里编程规范规定不可以直接使用log4j和logback等日志
//      而应该使用门面模式框架SLF4J
        Client client = new Client();
        client.eat();
    }
}
class Client {
    void eat() {
        Object food = Restaurant.getFood("扬州炒饭");
    }
}
class Restaurant {

    public static Object getFood(String 扬州炒饭) {
        System.out.println("切菜");
        System.out.println("炒饭");
        System.out.println("装盘");
        return new Object();
    }
}