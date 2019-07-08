import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class a = A.class;
        B b = new B();
        Method toString = a.getMethod("toString");
        String str = (String)toString.invoke(b);
        System.out.println(str);
    }

}
class A {
    @Override
    public String toString() {
        return "a";
    }
}
class B extends A{
    @Override
    public String toString() {
        return "b";
    }
}
