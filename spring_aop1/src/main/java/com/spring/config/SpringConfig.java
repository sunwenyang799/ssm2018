package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:03 2020/8/23
 * @ Description：Spring全局配置
 */
@Configuration
@ComponentScan("com.spring")
@EnableAspectJAutoProxy
public class SpringConfig {
}
