package 框架;

public class IOC原理 {
}
/**
 *         Resource resource = new ClassPathResource("applicationContext.xml");
 *         //将xml包装成resource
 *         DefaultListableBeanFactory  beanFactory = new DefaultListableBeanFactory();
 *         //创建bean工厂
 *         XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
 *         //创建xml解析Bean定义类 传入工厂供回调使用
 *         reader.loadBeanDefinitions(resource);
 *         //调用loadBeanDefinitions 传入要解析的源resource
 *         //这个方法首先会判断包装的Resource在当前线程内存不存在 采用ThreadLocal
 *         //如果不存在则新创建一个Set 将Set添加到ThreadLocal里面 然后把Resource缓存到set里面
 *         //在解析的流程中会获取Resource中InputSteam然后包装成Document doc
 *         //开始注册BeanDefinition（对Bean的定义解释）
 *         //在注册的过程中从doc中获取Element root
 *         //接下来采取委托模式 委托给BeanDefinitionParserDelegate这个类处理
 *         //BeanDefinitionParserDelegate类里面预定义了xml文件的标签常量
 *         //      preProcessXml(root);
 *         //		parseBeanDefinitions(root, this.delegate); 这里传入xml根和委托类
 *         //		postProcessXml(root);
 *         //上述三个方法是典型的模板模式 接下进入parseBeanDefinitions分析
 *         //就是循环读取 枚举类型 存入到BeanFactory里面的map里面
 *         //返回的是一个int值代表生成了多少个BeanDefinition
 *         //然后会将缓存在set里面的Resource清理掉 如果set是空的会从ThreadLocal里面删除
 *         //然后整个流程结束 此时没有生成任何Bean 生成的是BeanDefinition （可以设置加载即生成）
 *         Object obj = beanFactory.getBean("aa");
 *         //首先用BeanFactoryUtils检查BeanName
 *         //判断名字的开头是不是&字符开头 还有别名检查
 *         //然后进行Bean作用域判断
 *         //向alreadyCreated集合里面添加BeanName 添加的过程使用了synchronized锁
 *         //如果是单例模式 则通过单例工厂利用cglib+反射创建单例对象
 *         //生成Bean之后向下强转 类型有doGetBean指定
 *
 *         System.out.println(obj);
 */