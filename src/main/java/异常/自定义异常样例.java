package 异常;

public class 自定义异常样例 {
    public static void main(String[] args) {
//      之所以有自定义异常就是为了看名字 好精准定位错误
//      重要：如果重写的方法没有抛出异常 那么只能try不能throw
    }
}
class MyException extends Exception{
    MyException(String s){
        super(s);
    }
}