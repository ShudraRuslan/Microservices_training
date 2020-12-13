package com.example.demo.Api.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    public static final String Car_Key_Delete = "carDelete_routingKey";
    public static final String Car_Key_Create = "carCreate_routingKey";
    public static final String Car_Key_Update = "carUpdate_routingKey";


    @Bean
    public Queue queueCD() {
        return new Queue("car_queue_delete");
    }

    @Bean
    public Queue queueCC() {
        return new Queue("car_queue_create");
    }

    @Bean
    public Queue queueCU() {
        return new Queue("car_queue_update");
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingCD(Queue queueCD, TopicExchange exchange) {
        return BindingBuilder.bind(queueCD).to(exchange).with(Car_Key_Delete);
    }

    @Bean
    public Binding bindingCC(Queue queueCC, TopicExchange exchange) {
        return BindingBuilder.bind(queueCC).to(exchange).with(Car_Key_Create);
    }

    @Bean
    public Binding bindingCU(Queue queueCU, TopicExchange exchange) {
        return BindingBuilder.bind(queueCU).to(exchange).with(Car_Key_Update);
    }


}
