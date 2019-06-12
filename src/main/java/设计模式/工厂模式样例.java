package 设计模式;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class 工厂模式样例 {
    public static void main(String[] args) {
//        1.工厂模式是什么？
//          首先你要买的东西工厂都能生产，并且你不需要提供什么生产资料，
//          你只要告诉工厂你要买什么，工厂就给你什么。消费者只看结果，不关心
//          生产的过程。而工厂也就是生产者 制定统一标准和接口
            Potato potato = (Potato) BeanFactory.getBean("Potato");
            System.out.println(potato.getColor());
//          通过以上的代码就会发现 底层的实现类随便换 只要接口不变 修改xml就可以了
//          为什么要更换底层 接口里的方法体现是整个逻辑接口 而具体的实现就要面向过程
//          举两个例子：1.原先的底层for嵌套太多or递归层数过多 性能低下怎么办？
//                    2.当初具体实现代码的时候引用了一些外部包 和 一些方法
//                      他们当中的方法过时、或者废弃了怎么办？
//          那么你会发现一旦代码混杂在一起 发生以上情况要修改代码时 完了真的会死的 你就改吧
//          核心思想：解耦
    }
}
interface Potato{
    String getColor();
}
class PotatoImpl implements Potato{

    public String getColor() {
        return "yellow";
    }
}
class BeanFactory{
    public static Object getBean(String name){
        String claImplName = getClaIml(name);
        Object o = null;
        try {
            Class cla = Class.forName(claImplName);
            o = cla.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return o;
    }

    private static String getClaIml(String name) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/main/java/设计模式/config.xml");
            NodeList beanList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanList.getLength(); i ++){
                Node bean = beanList.item(i);
                NamedNodeMap beanAttr = bean.getAttributes();
                String id = beanAttr.getNamedItem("id").getNodeValue();
                if (id.equals(name)){
                    return beanAttr.getNamedItem("class").getNodeValue();
                }
            }
        }catch (ParserConfigurationException e){
            System.out.println("程序崩了");
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}