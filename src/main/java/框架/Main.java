package 框架;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        假设客户端发送过来的url已经被拦截在此
          String url = "Action/login";
          String [] names = url.split("/");
          String claName = names[0];
          String metName = names[1];
//        try {
//            Class cla = Class.forName("框架."+claName);
//            Object obj = cla.newInstance();
//            Field[] fields = cla.getDeclaredFields();
//            for (int i = 0; i < fields.length; i ++){
//                String fieldName = fields[i].getName();
//                Class type = fields[i].getType();
//                Method method = cla.getMethod(getSetName(fieldName), type);
//                method.invoke(obj, BeanFactory.getBean(type.toString()));
//            }
//            Method method = cla.getMethod(metName);
//            Object value = method.invoke(obj);
//            System.out.println(value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        上面先注释掉接下来我们引入AOP
        try {
            Class cla = Class.forName("框架."+claName);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(cla);
            enhancer.setCallback(new TaransactionInterceptor());
            Object obj = enhancer.create();
            System.out.println(cla == obj.getClass());
//            Class cla = obj.getClass();

//          -----------------------------------------------------

            Field[] fields = cla.getDeclaredFields();
            for (int i = 0; i < fields.length; i ++){
                String fieldName = fields[i].getName();
                Class type = fields[i].getType();
                Method method = cla.getMethod(getSetName(fieldName), type);
                Object bean = BeanFactory.getBean(type.toString());
//                method.invoke(obj, bean);
                fields[i].setAccessible(true);
                fields[i].set(obj, bean);
            }
            Method method = cla.getMethod(metName);
            Object value = method.invoke(obj);
            System.out.println(value);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getSetName(String name) {
        String str = ""+name.charAt(0);
        str = str.toUpperCase();
        return "set"+str+name.substring(1);
    }
}
class TaransactionInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务管理");
        System.out.println("--------------");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("我正在执行方法");
        System.out.println("--------------");
        System.out.println("事务管理关闭");
        return obj;
    }
}
class BeanFactory{

    private static HashMap<String, Object> IOC = new HashMap<String, Object>();

    public static Object getBean(String url){
        if (IOC.get(url) != null) return IOC.get(url);
        String name = "";
        for (int i = url.length()-1; i >= 0; i --){
            if (url.charAt(i) == '.') break;
            name = url.charAt(i)+name;
        }
        String claImplName = getClaIml(name);
        Object o = null;
        try {
            Class cla = Class.forName(claImplName);
            o = cla.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        IOC.put(url, o);
        return o;
    }

    private static String getClaIml(String name) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/main/java/框架/Beans.xml");
            NodeList beanList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanList.getLength(); i ++){
                Node bean = beanList.item(i);
                NamedNodeMap beanAttr = bean.getAttributes();
                String id = beanAttr.getNamedItem("id").getNodeValue();
                if (id.equals(name)){
                    return beanAttr.getNamedItem("class").getNodeValue();
                }
            }
        }catch (Exception e){
            System.out.println("程序崩了");
            e.printStackTrace();
        }
        return null;
    }
}
class Action{

    Service service;

    /**
     * 演示set注入方式
     * @param service
     */
    public void setService(Service service) {
        this.service = service;
    }

    public String login(){
        return service.getStr();
    }
}

interface Service{
    String getStr();
}

class ServiceImpl implements Service{

    public String getStr() {
        return "演示调用成功";
    }
}