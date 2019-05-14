package io.axoniq.demo.giftcard.messaging;

import io.axoniq.demo.giftcard.GcApp;
import io.axoniq.demo.giftcard.messaging.model.PersonCreatedEvent;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@Log
public class ReceiverService {

    @RabbitListener(queues = GcApp.queueName)
    public void receiveMessage(final Message<PersonCreatedEvent> message) {
        System.out.println("Received message with default configuration : " + message.toString());
        System.out.println(message.getPayload());
    }

}
