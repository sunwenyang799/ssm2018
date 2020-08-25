package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lenovo
 * @description: spring主配置类
 * @date 2020/8/25 16:34
 */
@Configuration
@ComponentScan({"com.spring","config"})
@EnableTransactionManagement
//@Import({JdbcConfig.class,TransactionConfig.class})
public class SpringConfig {

}
