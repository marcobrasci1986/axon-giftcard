package io.axoniq.demo.giftcard.messaging;

import io.axoniq.demo.giftcard.GcApp;
import io.axoniq.demo.giftcard.messaging.model.PersonCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@XSlf4j
public class PublisherService {
    public static final String ROUTING_KEY = "foo.bar.baz";
    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        log.info("Sending Message to exchange [{}] with routingKey [{}", GcApp.topicExchangeName, ROUTING_KEY);
        PersonCreatedEvent personCreatedEvent = PersonCreatedEvent.builder().id(UUID.randomUUID()).firstname("John").lastname("Doe").build();
        rabbitTemplate.convertAndSend(GcApp.topicExchangeName, ROUTING_KEY, personCreatedEvent);
    }
}
