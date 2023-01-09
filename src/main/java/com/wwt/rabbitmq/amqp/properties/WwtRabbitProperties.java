package com.wwt.rabbitmq.amqp.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @Author wwt
 * @ClassName WwtRabbitProperties.java
 * @Description rabbitmq属性配置类
 * @CreateTime 2023-01-08 22:18
 */
@Data
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class WwtRabbitProperties {

    private static final int DEFAULT_PORT = 5672;

    private static final int DEFAULT_PORT_SECURE = 5671;

    private static final int DEFAULT_STREAM_PORT = 5552;

    private String virtualHost;

    private String host = "localhost";

    private Integer port;

    private String username = "guest";

    private String password = "guest";

    /***
     * 客户端请求的每个链接的通道数。0表示无限
     */
    //private int requestedChannelMax = 2047;

    /***
     * 配置监听
     */
    private final Listener listener = new Listener();


    /***
     * 监听，内部类
     */
    public static class Listener{

        /***
         * 监听容器类型
         */
        private ContainerType type = ContainerType.SIMPLE;

        /***
         * 配置简单容器
         */
        private final SimpleContainer simple = new SimpleContainer();

        /***
         * 直接容器
         */
        //private final DirectContainer direct = new DirectContainer();

        /***
         * 流容器
         */
        //private final StreamContainer stream = new StreamContainer();
    }


    public enum ContainerType {

        /**
         * RabbitMQ使用者将消息分发给调用线程的容器。
         */
        SIMPLE,

        /**
         * 在消费线程上直接调用rabbitmq
         */
        DIRECT,

        /**
         * Container that uses the RabbitMQ Stream Client.
         */
        STREAM

    }

    /**
     * Configuration properties for {@code SimpleMessageListenerContainer}.
     */
    public static class SimpleContainer extends AmqpContainer {

        /**
         * 消费者的最小数量
         */
        private Integer concurrency;

        /**
         * 消费者的最大数量
         */
        private Integer maxConcurrency;


    }



    /***
     * amqp容器
     */
    public abstract static class AmqpContainer extends BaseContainer {
        /***
         * 枚举类，容器确认模式
         */
        private WwtAcknowledgeMode acknowledgeMode;

        /***
         * 在每个服务器上可以未确认的最大消息数消费者。
         */
        private Integer prefetch;
    }



    public abstract static class BaseContainer {

        /**
         * 容器启动时是否自动启动，默认自动启动
         */
        private boolean autoStartup = true;

        public boolean isAutoStartup() {
            return this.autoStartup;
        }

        public void setAutoStartup(boolean autoStartup) {
            this.autoStartup = autoStartup;
        }

    }



}
