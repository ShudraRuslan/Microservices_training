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
    public static final String Driver_Key_Delete = "driverDelete_routingKey";
    public static final String Driver_Key_Create = "driverCreate_routingKey";
    public static final String Driver_Key_Update = "driverUpdate_routingKey";


    @Bean
    public Queue queueDD() {
        return new Queue("driver_queue_delete");
    }

    @Bean
    public Queue queueDC() {
        return new Queue("driver_queue_create");
    }

    @Bean
    public Queue queueDU() {
        return new Queue("driver_queue_update");
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Exchange);
    }

    @Bean
    public Binding bindingCD(Queue queueDD, TopicExchange exchange) {
        return BindingBuilder.bind(queueDD).to(exchange).with(Driver_Key_Delete);
    }

    @Bean
    public Binding bindingCC(Queue queueDC, TopicExchange exchange) {
        return BindingBuilder.bind(queueDC).to(exchange).with(Driver_Key_Create);
    }

    @Bean
    public Binding bindingCU(Queue queueDU, TopicExchange exchange) {
        return BindingBuilder.bind(queueDU).to(exchange).with(Driver_Key_Update);
    }


}
