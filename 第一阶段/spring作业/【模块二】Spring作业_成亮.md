1、学员自定义@Service、@Autowired、@Transactional注解类，完成基于注解的IOC容器（Bean对象创建及依赖注入维护）和声明式事务控制，写到转账工程中，并且可以实现转账成功和转账异常时事务回滚

注意考虑以下情况：

 1）注解有无value属性值【@service（value=""@Repository（value=""）】 

 2）service层是否实现接口的情况【jdk还是cglib】



【答】：代码具体见code文件夹。

（1）在DruidUtils类中，修订数据库连接（修改为Mysql 8的连接配置，本地数据库为Mysql 8）。

（2）创建注解@DefineService、@DefineAutowired、@DefineTransactional。详见代码annotation包。

（3）beans.xml开启注解扫描，base-package扫描路径是com.lagou.edu

（4）在代码factory包下，新增BeanFactoryAnnotation.java用于实现注解开发。具体包括解析xml并扫描获取被注解的类；通过反射技术实例化对象并且保存到map；通过set方式注入依赖；使用代理对象处理Transactional。

（5）在TransferServiceImpl、ProxyFactory、JdbcAccountDaoImpl、TransactionManager等类上，加上自定义的注解。

（6）在TransferServiceImpl.transfer方法中加上/去掉验证代码（int c = 1/0;），验证功能。





2、根据源码剖析，记录spring循环依赖处理机制中的调用关系，画出uml时序图【主要方法或者类的作用进行文字注明】

注意：提交作业的图片格式png/jpg格式

org.springframework.beans.factory.support.AbstractBeanDefinitionReader#loadBeanDefinitionsorg.springframework.beans.factory.xml.XmlBeanDefinitionReader#loadBeanDefinitions(org.springframework.core.io.Resource)



【答】：uml时序图具体见spring循环依赖.png

