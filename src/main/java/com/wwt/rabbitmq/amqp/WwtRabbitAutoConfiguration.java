package com.wwt.rabbitmq.amqp;

import com.rabbitmq.client.Channel;
import com.wwt.rabbitmq.amqp.properties.WwtRabbitProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @Author wwt
 * @ClassName WwtRabbitAutoConfiguration.java
 * @Description rabbitmq自动配置类
 * @CreateTime 2023-01-09 22:27
 */
//自动配置，不做bean的切面初始化，提升性能
@AutoConfiguration
//当classpath下找到下面的类时，初始化配置这个bean
@ConditionalOnClass({RabbitTemplate.class, Channel.class})
//开启WwtRabbitProperties.class加载，光加上@ConfigurationProperties不起作用，必须要加上这个开启的注解才会初始化去读取配置文件中的内容
@EnableConfigurationProperties(WwtRabbitProperties.class)
//导入这个自动化配置，而只有使用上@EnableRabbit这个注解才会起作用，相当于开关
@Import({WwtRabbitAnnotationDrivenConfiguration.class})
public class WwtRabbitAutoConfiguration {
}
