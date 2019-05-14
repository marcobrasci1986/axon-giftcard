package io.axoniq.demo.giftcard.messaging;

import io.axoniq.demo.giftcard.GcApp;
import io.axoniq.demo.giftcard.messaging.model.PersonCreatedEvent;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@XSlf4j
public class ReceiverService {

    @RabbitListener(queues = GcApp.queueName)
    public void receiveMessage(final Message<PersonCreatedEvent> message) {
        log.info("Received message: {}. With headers: {}" + message.getPayload().toString(), message.getHeaders());
        log.info(message.getPayload().toString());
    }

}
