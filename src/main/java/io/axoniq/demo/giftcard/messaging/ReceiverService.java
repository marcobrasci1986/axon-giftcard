package io.axoniq.demo.giftcard.messaging;

import io.axoniq.demo.giftcard.GcApp;
import io.axoniq.demo.giftcard.messaging.config.RabbitMqConfiguration;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@XSlf4j
public class ReceiverService {

    /**
     * Automatic Json conversions
     * @param genericMessage
     */
//    @RabbitListener(queues = RabbitMqConfiguration.queueName)
//    public void receiveMessage(final PersonCreatedEvent personCreatedEvent) {
//        log.info("Received message: {}", personCreatedEvent);
//    }


    @RabbitListener(queues = RabbitMqConfiguration.queueName)
    public void receiveMessage(final Message genericMessage) {
        log.info("Received message: {}", genericMessage);

        Map<String, Object> headers = genericMessage.getMessageProperties().getHeaders();
        String payload = new String(genericMessage.getBody());

        System.out.println(payload);
    }

}
