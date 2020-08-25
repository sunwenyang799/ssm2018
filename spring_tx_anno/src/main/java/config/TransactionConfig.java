package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lenovo
 * @description: 事务控制配置
 * @date 2020/8/25 16:42
 */
@Configuration
public class TransactionConfig {

    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
     public DataSourceTransactionManager  getTransactionManger(DataSource dataSource){
         return new DataSourceTransactionManager(dataSource);
     }
}
