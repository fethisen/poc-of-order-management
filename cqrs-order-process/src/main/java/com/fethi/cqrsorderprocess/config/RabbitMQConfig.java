package com.fethi.cqrsorderprocess.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.publisher.name}")
    private String queueNamePublisher;

    @Value("${rabbitmq.queue.listener.name}")
    private String queueNameListener;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.publisher.key}")
    private String routingKeyPublisher;

    @Value("${rabbitmq.routing.listener.key}")
    private String routingKeyListener;

    // spring bean for rabbitmq queue
    @Bean
    public Queue queuePublisher() {
        return new Queue(queueNamePublisher);
    }

    @Bean
    public Queue queueListener() {
        return new Queue(queueNameListener);
    }

    // spring bean for rabbitmq exchange
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }

    // binding between queue and exchange using routing key
    @Bean
    public Binding bindingPublisher() {
        return BindingBuilder
                .bind(queuePublisher())
                .to(exchange())
                .with(routingKeyPublisher);
    }

    @Bean
    public Binding bindingListener() {
        return BindingBuilder
                .bind(queueListener())
                .to(exchange())
                .with(routingKeyListener);
    }

    public String getQueueNamePublisher() {
        return queueNamePublisher;
    }

    public void setQueueNamePublisher(String queueNamePublisher) {
        this.queueNamePublisher = queueNamePublisher;
    }

    public String getQueueNameListener() {
        return queueNameListener;
    }

    public void setQueueNameListener(String queueNameListener) {
        this.queueNameListener = queueNameListener;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKeyPublisher() {
        return routingKeyPublisher;
    }

    public void setRoutingKeyPublisher(String routingKeyPublisher) {
        this.routingKeyPublisher = routingKeyPublisher;
    }

    public String getRoutingKeyListener() {
        return routingKeyListener;
    }

    public void setRoutingKeyListener(String routingKeyListener) {
        this.routingKeyListener = routingKeyListener;
    }
}
