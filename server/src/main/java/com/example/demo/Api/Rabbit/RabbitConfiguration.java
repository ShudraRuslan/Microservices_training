package com.example.demo.Api.Rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    public static final String EXCHANGE = "exchange";
    public static final String Car_Key_Delete = "carDelete_routingKey";
    public static final String Car_Key_Create = "carCreate_routingKey";
    public static final String Car_Key_Update = "carUpdate_routingKey";
    public static final String Cashier_Key_Create = "cashierCreate_routingKey";
    public static final String Cashier_Key_Update = "cashierUpdate_routingKey";
    public static final String Client_Key_Create = "clientCreate_routingKey";
    public static final String Driver_Key_Delete = "driverDelete_routingKey";
    public static final String Driver_Key_Create = "driverCreate_routingKey";
    public static final String Driver_Key_Update = "driverUpdate_routingKey";
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
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding bindingOC(Queue queueOC, TopicExchange exchange) {
        return BindingBuilder.bind(queueOC).to(exchange).with(Order_Key_Create);
    }

    @Bean
    public Binding bindingOU(Queue queueOU, TopicExchange exchange) {
        return BindingBuilder.bind(queueOU).to(exchange).with(Order_Key_Update);
    }

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

    @Bean
    public Queue queueClC() {
        return new Queue("client_queue_create");
    }

    @Bean
    public Binding bindingClC(Queue queueClC, TopicExchange exchange) {
        return BindingBuilder.bind(queueClC).to(exchange).with(Client_Key_Create);
    }

    @Bean
    public Queue queueCshC() {
        return new Queue("cashier_queue_create");
    }

    @Bean
    public Queue queueCshU() {
        return new Queue("cashier_queue_update");
    }


    @Bean
    public Binding bindingCshC(Queue queueCshC, TopicExchange exchange) {
        return BindingBuilder.bind(queueCshC).to(exchange).with(Cashier_Key_Create);
    }

    @Bean
    public Binding bindingCshU(Queue queueCshU, TopicExchange exchange) {
        return BindingBuilder.bind(queueCshU).to(exchange).with(Cashier_Key_Update);
    }


    @Bean
    public Queue queueCrD() {
        return new Queue("car_queue_delete");
    }

    @Bean
    public Queue queueCrC() {
        return new Queue("car_queue_create");
    }

    @Bean
    public Queue queueCrU() {
        return new Queue("car_queue_update");
    }

    @Bean
    public Binding bindingCrD(Queue queueCrD, TopicExchange exchange) {
        return BindingBuilder.bind(queueCrD).to(exchange).with(Car_Key_Delete);
    }

    @Bean
    public Binding bindingCrC(Queue queueCrC, TopicExchange exchange) {
        return BindingBuilder.bind(queueCrC).to(exchange).with(Car_Key_Create);
    }

    @Bean
    public Binding bindingCrU(Queue queueCrU, TopicExchange exchange) {
        return BindingBuilder.bind(queueCrU).to(exchange).with(Car_Key_Update);
    }


}
