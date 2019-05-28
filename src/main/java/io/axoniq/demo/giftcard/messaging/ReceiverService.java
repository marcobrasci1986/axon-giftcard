package io.axoniq.demo.giftcard.messaging;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.axoniq.demo.giftcard.messaging.config.RabbitMqConfiguration;
import io.axoniq.demo.giftcard.messaging.model.BaseEvent;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@XSlf4j
public class ReceiverService {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Automatic Json conversions
     *
     * @param genericMessage
     */
    @RabbitListener(queues = RabbitMqConfiguration.queueName)
    public void receiveMessage(final Message genericMessage) throws IOException {
        log.info("Received message: {}", genericMessage);

        Map<String, Object> headers = genericMessage.getMessageProperties().getHeaders();
        String payload = new String(genericMessage.getBody());

        System.out.println(payload);

        BaseEvent baseEvent = objectMapper.readValue(payload, BaseEvent.class);
        System.out.println(baseEvent);
    }

}
