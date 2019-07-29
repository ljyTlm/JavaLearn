package 虚拟机;

public class 自定义类加载器 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> ds = classLoader.loadClass("ds");

    }
}
class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = {1,2,3};
        if (data == null) {
            throw new ClassNotFoundException();
        }else {
            return defineClass(name, data, 0, data.length);
        }
    }
}
