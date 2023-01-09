package com.wwt.rabbitmq.amqp.properties;

/**
 * @Author wwt
 * @ClassName AcknowledgeMode.java
 * @Description 容器的确认模式
 * @CreateTime 2023-01-09 21:57
 */
public enum WwtAcknowledgeMode {

    NONE,

    //手动签收
    MANUAL,

    //自动签收
    AUTO;
}
