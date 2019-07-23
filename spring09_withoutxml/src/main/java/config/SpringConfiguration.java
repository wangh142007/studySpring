package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用时一样的，都是用于指定创建容器时要扫描的包
 *                  我们使用此注解就等同于在xml配置了：
 *                  <context:component-scan base-package="com.wh"></context:component-scan>
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *          name：用于指定bean的id。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架去容器中查找有没有可用的bean对象。
 *          查找方式和Autowired注释的作用时一样的
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码。
 *                  当我们使用import的注解之后，有import注释的类就是父配置类，而导入都是子配置类
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径
 *                  关键字：classpath,表示类路径下
 *
 */
//@Configuration
@ComponentScan("com.wh")
@PropertySource("classpath:jdbcConfig.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {

}
