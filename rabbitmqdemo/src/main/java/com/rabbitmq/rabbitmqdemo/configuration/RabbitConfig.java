package com.rabbitmq.rabbitmqdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

@Configuration
public class RabbitConfig {
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory("localhost"); // Replace with your RabbitMQ server address
        factory.setPort(5672); // Default port for RabbitMQ
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

//    @Bean
//    public RabbitAdmin rabbitAdmin(CachingConnectionFactory connectionFactory) {
//        return new RabbitAdmin(connectionFactory);
//    }
}
