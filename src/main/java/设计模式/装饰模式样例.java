package 设计模式;

public class 装饰模式样例 {
    public static void main(String[] args) {
        BueautifulWall wall = new BueautifulWall(new WhiteWall());
        wall.selectWall();
    }
}
interface Wall{
    void selectWall();
}
class WhiteWall implements Wall {

    @Override
    public void selectWall() {
        System.out.println("衣服架");
        System.out.println("射击靶");
    }
}
class BueautifulWall implements Wall{
    Wall wall;
//  被装饰类的引用

    BueautifulWall(){}

    BueautifulWall(Wall wall){
        this.wall = wall;
    }

//  对原有功能进行升级
    @Override
    public void selectWall() {
        wall.selectWall();
        System.out.println("装饰画");
        System.out.println("背景墙");
    }
}