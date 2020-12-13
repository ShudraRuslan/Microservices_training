package com.example.demo.Api.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String Exchange = "exchange";
    public static final String Order_Key_Create = "orderCreate_routingKey";
    public static final String Order_Key_Update = "orderUpdate_routingKey";


    @Bean
    public Queue queueOC() {
        return new Queue("order_queue_create");
    }

    @Bean
    public Queue queueOU() {
        return new Queue("order_queue_update");
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange);
    }

    @Bean
    public Binding bindingOU(Queue queueOC, TopicExchange exchange) {
        return BindingBuilder.bind(queueOC).to(exchange).with(Order_Key_Create);
    }

    @Bean
    public Binding bindingOC(Queue queueOU, TopicExchange exchange) {
        return BindingBuilder.bind(queueOU).to(exchange).with(Order_Key_Update);
    }


}
