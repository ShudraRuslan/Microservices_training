package com.example.demo.Api.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String Client_Key_Create = "clientCreate_routingKey";


    @Bean
    public Queue queueCC() {
        return new Queue("client_queue_create");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingCC(Queue queueCC, TopicExchange exchange) {
        return BindingBuilder.bind(queueCC).to(exchange).with(Client_Key_Create);
    }


}
