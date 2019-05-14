package io.axoniq.demo.giftcard;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * AMQP: Advanced Message Queuing Protocol
 * https://spring.io/guides/gs/messaging-rabbitmq/
 * https://www.youtube.com/watch?v=deG25y_r6OY
 */
@SpringBootApplication
@EnableScheduling
public class GcApp {

    public static final String topicExchangeName = "spring-boot-exchange";
    public static final String queueName = "spring-boot";
    public static final String ROUTING_KEY = "foo.bar.#";

    public static void main(String[] args) {
        SpringApplication.run(GcApp.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    /**
     * Exchange acts like a load balancer.
     * An exchange connects to a queue via a binding and a binding key
     * <p>
     * Exchange types:
     * Fanout exchange: ignores the routing key and sends te message to all queues
     * Direct exchange: routing key = binding key
     * Topic exchange: partial matching of binding key (regex matching)
     * Header exchange: uses the message header instead of the routing key
     * Default (nameless) exchange: routing key = queue name
     * <p>
     * Message needs to specify a routing key
     *
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     * A binding is a relationship between an exchange and a queue.
     * The queue is interested in messages from this exchange.
     * <p>
     * The routing key is foo.bar.#.
     * Which means any message sent with a routing key beginning with foo.bar. will be routed to the queue.
     */
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    /**
     * To send message to queue in JsonFormat we need some Converter configuration
     */
    @Bean
    public Jackson2JsonMessageConverter producerMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Overwrite default implementation
     */
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerMessageConverter());
        return rabbitTemplate;

    }


}
