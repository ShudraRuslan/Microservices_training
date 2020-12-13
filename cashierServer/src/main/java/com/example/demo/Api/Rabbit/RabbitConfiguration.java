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
    public static final String Cashier_Key_Create = "cashierCreate_routingKey";
    public static final String Cashier_Key_Update = "cashierUpdate_routingKey";


    @Bean
    public Queue queueCC() {
        return new Queue("cashier_queue_create");
    }

    @Bean
    public Queue queueCU() {
        return new Queue("cashier_queue_update");
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange);
    }

    @Bean
    public Binding bindingCC(Queue queueCC, TopicExchange exchange) {
        return BindingBuilder.bind(queueCC).to(exchange).with(Cashier_Key_Create);
    }

    @Bean
    public Binding bindingCU(Queue queueCU, TopicExchange exchange) {
        return BindingBuilder.bind(queueCU).to(exchange).with(Cashier_Key_Update);
    }


}
