package 框架;

public class spring事务处理 {
}
/**
 * 事务处理分为编程式事务和声明式事务
 * 声明式事务：
 *  在xml文件中配置 数据源 数据库连接池
 *      有几个重要参数
 *      1初始化大小
 *      2最大连接数
 *      3最大小空闲数
 *      4等待时间
 *  然后配置一个Bean标签 选择将事务交给那个框架管理
 *      1jdbc是DataSourceTransactionManager
 *      2hibernate是HibernateTransactionManager
 *      3java原生事务是JtaTransactionManager（多个数据源）
 *  事务管理类有几个重要的方法
 *      1事务是否只读
 *      2事务的begin
 *      2事务的挂起
 *      3事务的提交
 *      4事务的回滚
 *  在begin方法里面设置了事务的隔离级别
 *  这个隔离级别是从连接点中获取的
 *  在代码中我们可以设置事务的传播机制总共有七种
 *      1.PROPAGATION_REQUIRED	required 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
 *      2.PROPAGATION_SUPPORTS	supports 支持当前事务，如果当前没有事务，就以非事务方式执行。
 *      3.PROPAGATION_MANDATORY	mandatory 使用当前的事务，如果当前没有事务，就抛出异常。
 *      4.PROPAGATION_REQUIRES_NEW	requires new 新建事务，如果当前存在事务，把当前事务挂起。
 *      5.PROPAGATION_NOT_SUPPORTED	no supported 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
 *      6.PROPAGATION_NEVER	never 以非事务方式执行，如果当前存在事务，则抛出异常。
 *      7.PROPAGATION_NESTED	nested 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
 *  使用@Transaction(propagation=Propagation.REQUIRED)
 *  使用事务可以让我们的逻辑代码更加灵活 有的时候我们不能因为一个操作错了就全盘回滚 我们就可以设置事务
 *
 *
 */