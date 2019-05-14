package io.axoniq.demo.giftcard.messaging;

import io.axoniq.demo.giftcard.GcApp;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final RabbitTemplate rabbitTemplate;
    private final ReceiverService receiver;


    @Scheduled(fixedDelay = 3000L)
    public void run() {
        System.out.println("Sending message ...");
        rabbitTemplate.convertAndSend(GcApp.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ");


    }
}
