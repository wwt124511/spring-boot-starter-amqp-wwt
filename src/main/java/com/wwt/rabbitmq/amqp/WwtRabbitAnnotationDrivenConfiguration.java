package com.wwt.rabbitmq.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wwt
 * @ClassName WwtRabbitAnnotationDrivenConfiguration.java
 * @Description TODO
 * @CreateTime 2023-01-09 22:33
 */
@Configuration(proxyBeanMethods = false)
//当配置这个注解，classpath下能找到这个类时才会初始化这个配置，相当于通过这个@EnableRabbit注解开启这个自动化配置，是个开关
@ConditionalOnClass(EnableRabbit.class)
public class WwtRabbitAnnotationDrivenConfiguration {
}
