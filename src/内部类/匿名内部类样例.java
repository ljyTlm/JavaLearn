package 内部类;

public class 匿名内部类样例 {
    //匿名内部类的好处就是 局部功能类匿名 那就意味你的代码里没有太多的类 结构清晰
    void show(){
        String str = getString(new 匿名() {
            @Override
            public String print() {
                return "yanshi";
            }
        });
        System.out.println(str);
    }

    String getString(匿名 a){
        return a.print();
    };
}
interface 匿名{
    String print();
}
