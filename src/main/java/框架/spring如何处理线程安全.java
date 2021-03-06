package 框架;

public class spring如何处理线程安全 {
}
/**
 * spring中默认的bean是单例的 也就是多个线程访问时用的是同一个bean
 * 会有线程安全问题有如下解决方案
 *  1.不要在类中使用全局变量 在方法内 局部变量每个线程独立不会造成线程安全问题
 *  2.设置Scope属性设置为Prototype 变为多例
 *  3.使用ThreadLocal解决线程安全问题以空间换时间 不需要考虑锁不锁的问题 每个线程独立访问
 */